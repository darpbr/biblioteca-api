#!/bin/bash

# Log user prompt submission

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

# Read input from Copilot (contains prompt info)
INPUT=$(cat)

# Create logs directory if it doesn't exist
mkdir -p logs/copilot

# Extract timestamp
TIMESTAMP=$(date -u +"%Y-%m-%dT%H:%M:%SZ")

# Log prompt using jq for proper JSON encoding
jq -Rn --arg timestamp "$TIMESTAMP" --arg level "${LOG_LEVEL:-INFO}" \
  '{"timestamp":$timestamp,"event":"userPromptSubmitted","level":$level}' \
  >> logs/copilot/prompts.log

exit 0
