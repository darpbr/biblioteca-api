---
name: github-issues
description: 'Create, update, and manage GitHub issues using MCP tools. Use this skill when users want to create bug reports, feature requests, or task issues, update existing issues, add labels/assignees/milestones, set issue fields (dates, priority, custom fields), set issue types, manage issue workflows, link issues, add dependencies, or track blocked-by/blocking relationships. Triggers on requests like "create an issue", "file a bug", "request a feature", "update issue X", "set the priority", "set the start date", "link issues", "add dependency", "blocked by", "blocking", or any GitHub issue management task.'
---

# GitHub Issues

Manage GitHub issues using the `@modelcontextprotocol/server-github` MCP server.

## Available Tools

### MCP Tools (read operations)

| Tool | Purpose |
|------|---------|
| `mcp__github__issue_read` | Read issue details, sub-issues, comments, labels (methods: get, get_comments, get_sub_issues, get_labels) |
| `mcp__github__list_issues` | List and filter repository issues by state, labels, date |
| `mcp__github__search_issues` | Search issues across repos using GitHub search syntax |
| `mcp__github__projects_list` | List projects, project fields, project items, status updates |
| `mcp__github__projects_get` | Get details of a project, field, item, or status update |
| `mcp__github__projects_write` | Add/update/delete project items, create status updates |

### CLI / REST API (write operations)

The MCP server does not currently support creating, updating, or commenting on issues. Use `gh api` for these operations.

| Operation | Command |
|-----------|---------|
| Create issue | `gh api repos/{owner}/{repo}/issues -X POST -f title=... -f body=...` |
| Update issue | `gh api repos/{owner}/{repo}/issues/{number} -X PATCH -f title=... -f state=...` |
| Add comment | `gh api repos/{owner}/{repo}/issues/{number}/comments -X POST -f body=...` |
| Close issue | `gh api repos/{owner}/{repo}/issues/{number} -X PATCH -f state=closed` |

**Note:** `gh issue create` works for basic issue creation but does **not** support the `--type` flag. Use `gh api` when you need to set issue types.

## Workflow

1. **Determine action**: Create, update, or query?
2. **Gather context**: Get repo info, existing labels, milestones if needed
3. **Structure content**: Use appropriate template from [references/templates.md](references/templates.md)
4. **Execute**: Use MCP tools for reads, `gh api` for writes
5. **Confirm**: Report the issue URL to user

... (truncated for brevity in file)
