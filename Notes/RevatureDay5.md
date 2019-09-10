# 9/9/2019

Linux Commands!

ls
ls -a
ls -l
cd ..
cd /folder/otherFolder
mkdir folderName
cat fileName

Git Commands!

a tool for source code management
distributive version control
why? roll back to previous versions of code base
collaboration- working on different part of an application
if you want anything to be accessible from the terminal
you need to add it to your path

git clone "URLGOESHERE.git"
adds a directory = repository = folder
also adds a .git repository
get into the local repo via git bash
git status will print info about branching, changes, files, commits, etc
git pull -> fetch and merge changes from remote to local
git add . ~adds everything that was modified and has them track all changes
git commit -m "messageHERE" ~saves a snapshot of the repo with an ID
git push ~the remote repo sees it

MAVEN!
Build tool from Apache
An installation already comes with eclipse
Define a lifecycle with goals or steps
preparing your code for run, distribution, etc
goals- clean the project, purge all of you compiled code artifacts and recompile
package- create .jar (java archive) or .war (web archive)- compressed compiled artifacts
test- runs unit tests
Dependency manager
15.1 Million Artifacts up in the cloud for your use
local maven repository -> .m2 
maven central repository is in the cloud

Using Maven!
project has pom.xml (neccesity)
pom.xml -> project object model
build instructions, list of dependencies, plugins
Maven will go and download the ones you ask for it to get
