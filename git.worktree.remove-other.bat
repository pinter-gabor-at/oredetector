set cwd=%~dp0
git worktree remove %cwd:~0,-1%-other
set cwd=
