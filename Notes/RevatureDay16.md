# 9/26/2019

## Software Development Life Cycles

Methodologies for constructing a software application

### Big Bang

Everything, all at once, no formal organization, high management overhead

### Waterfall

Sequential Development
think of an assembly line, before work begins, every stage of development and feature of finished
product is planned
low management overhead, little communication between teams
not particularly practical for many software products
can't release gradual versions
refine requests
communicate w/ stakeholders

### Agile

Iterative Development
Break down requests into "stories", granular tasks, or behaviours
Assign various points to stories to quantify progress
Stand up -> Check in

within the Agile Software Development Life Cycle
-> Scrum
    "Sprints" are short development cycles
    typically a couple of weeks (1-3 weeks)
    Define a sprint backlog of stories (selected from the product backlog)
    Use burndown charts to visualize progress
    Planning, Retrospective, Release

-> Kanban
    Continous plan of work and delivery of features
    Keep track of multiple teams working on multiple features
    Team moves at a "velocity" points per time

### Node.js

Server-side JS Runtime
-> Environment on which we can use javascript
-> Uses chrome v8 engine (provides mechanics for just in time compiling)
    (runtime also includes libraries available during execution)

NPM is the node package manager
registry of many different packages of javascript software (like the maven central repository)
Free, opensource, and can be used through the command line

"package"-> group of files defined by a package.json file (similar to pom.xml)
name and version of package
other packages project depends on
build instructions
