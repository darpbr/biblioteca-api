#!/bin/bash

# Log session end event

set -euo pipefail

# Skip if logging disabled
if [[ "${SKIP_LOGGING:-}" == "true" ]]; then
  exit 0
fi

# Verify jq is available
if ! command -v jq &> /dev/null; then
  echo "Error: jq is required for logging" >&2
  exit 1
fi

# Read input from Copilot
INPUT=$(cat)

# Create logs directory if it doesn't exist
mkdir -p logs/copilot

# Extract timestamp
TIMESTAMP=$(date -u +"%Y-%m-%dT%H:%M:%SZ")

# Log session end using jq for proper JSON encoding
jq -Rn --arg timestamp "$TIMESTAMP" \
  '{"timestamp":$timestamp,"event":"sessionEnd"}' \
  >> logs/copilot/session.log

echo "📝 Session end logged"
exit 0
