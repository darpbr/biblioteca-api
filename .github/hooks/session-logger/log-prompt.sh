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

# Create logs directory if it doesn't exist
mkdir -p logs/copilot

# Read input from Gemini CLI (stdin), which is expected to be a JSON object
# containing the prompt. We extract the prompt text and merge it with our log entry.
# We also include a placeholder for tokenCount, which is currently not supplied.
jq -R 'fromjson? | . as $input | {
    "timestamp": (now | todateiso8601),
    "event": "userPromptSubmitted",
    "level": (env.LOG_LEVEL // "INFO"),
    "prompt": ($input.prompt // "PROMPT_FIELD_NOT_FOUND_IN_INPUT"),
    "tokenCount": ($input.tokenCount // null)
  }' >> logs/copilot/prompts.log

exit 0
