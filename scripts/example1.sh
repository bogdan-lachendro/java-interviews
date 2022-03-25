git checkout example1
user=`git config --global --get user.name`
user="${user// /_}"
git checkout -b example1.$user