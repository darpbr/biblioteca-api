#!/bin/bash

# Log session start event

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

# Extract timestamp and session info
TIMESTAMP=$(date -u +"%Y-%m-%dT%H:%M:%SZ")
SESSION_ID=$(date +%s%N)
CWD=$(pwd)

# Log session start using jq for proper JSON encoding
jq -Rn --arg timestamp "$TIMESTAMP" --arg cwd "$CWD" --arg sessionId "$SESSION_ID" \
  '{"timestamp":$timestamp,"event":"sessionStart","sessionId":$sessionId,"cwd":$cwd}' \
  >> logs/copilot/session.log

# Save session ID for the sessionEnd script
echo "$SESSION_ID" > /tmp/gemini_session_id.log

echo "📝 Session started and logged with ID: $SESSION_ID"
exit 0
