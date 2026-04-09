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

# Read session ID from temp file
SESSION_ID_FILE="/tmp/gemini_session_id.log"
if [[ -f "$SESSION_ID_FILE" ]]; then
  SESSION_ID=$(cat "$SESSION_ID_FILE")
  rm "$SESSION_ID_FILE"
else
  SESSION_ID="unknown"
fi

# Extract timestamp
TIMESTAMP=$(date -u +"%Y-%m-%dT%H:%M:%SZ")

# Log session end using jq for proper JSON encoding
jq -Rn --arg timestamp "$TIMESTAMP" --arg sessionId "$SESSION_ID" \
  '{"timestamp":$timestamp,"event":"sessionEnd","sessionId":$sessionId}' \
  >> logs/copilot/session.log

echo "📝 Session end logged for ID: $SESSION_ID"
exit 0
