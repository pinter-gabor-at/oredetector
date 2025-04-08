set cwd=%~dp0
git worktree add -d %cwd:~0,-1%-other
set cwd=
