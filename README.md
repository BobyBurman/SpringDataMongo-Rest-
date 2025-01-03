Git Bash:

git init
git status
git add .
git commit -m "first git commit"
git status
git branch -M release or main  

git remote add origin https://github.com/BobyBurman/Docker-Demo.git

git push -u origin release or main

git checkout <branch_name>  -->If you want to switch to an already existing branch, run the following command:
git switch <branch_name>

git checkout -b <new_branch_name> -->If you want to create a new branch and switch to it immediately, you can do that in one command.
git switch -c <new_branch_name>

git branch --> check the current branch
