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

### TypeScript

Programming language which is a superset of ES2015
Developed by microsoft open-source since 2012
Designed to make development of large projects easier
.ts
Transpile (source to source compile)
to javascript ES3t
"Compile-to-js" "targets" javascript
static typing ("strong typing")
JS: let x = 5;
    x = "five";
TS: let x:number = 5; // :number is type assertion
    x = "five"; // X NO DOESN'T WORK
JS: relied on infered type
TS: declared type

let x; // in TS becomes an infered type called any
let x:any;

String, number, boolean, object

let x:number[] = ....
let y:Array<number> = ....

Tuples: Array with predefined structure
let x: [String, number]
x = ["hello", 5] // works
x = [5, "hello"] // DOES NOT work

enum Color {"red","blue"};
let x:Color = Color.blue;

void, undefined, null, never, any

-> other features
interfaces, abstract classes, extends, implements

Access modifiers
piblic
private
protected

static
readonly

Modules
-> ES6 modules, not angular modules
module-per-file in JS ES6+
any classes, variables, functions, etc must have the export keyword
to be accessible outside the file
resources from outside file must be imported with import statements
at the top of the file

### Angular (Open source from google)

framework for building user-facing applications

version history
upto 1.6: AngularJS
-> JS
-> LOOKED LIKE JQUERY
-> Single page Applications (SPAs)
single index page that lets you swap out views
swap out view that reuses content
-> library

2+: Angular
-> TS
-> Runs w/ node
-> platform
-> webpack is used to bundle applications (transpile, minify, aggregate)
-> testing w/ jasmine, karma, protractor
-> organized into modules and components ( not the same as modules in ES6/node.js)
-> Angular CLI -> install w/ npm
    ng (best command)

Angular 2,4,5,6,7,8
6,7,8 are still being supported

a Module in Angular is the basic large scale unit of organization
it holds related components, directives, pipes, and services

@NgModule decorator on a class
declaration makes it a module

the annotation provides meta-programming

External libraries in Angular are included as modules
(FormsModule, RouterModule, HttpClientModule)
