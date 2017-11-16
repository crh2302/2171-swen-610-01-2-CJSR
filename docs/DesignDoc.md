# PROJECT Design Documentation

## Executive Summary

The WebCheckers project is a web application for people to play checkers online. A person can sign-in with any username of their choosing, so long as it is not already in use, and select an opponent from the list of players available to play a game of checkers against. All checkers games played are governed by the American rules.

### Purpose
This documentation gives the general idea of the product being developed and the technologies, models being used to implement the product. It contains every detail that’s being added to the product in order to let a non-team member to understand what’s being implemented and why.

## Requirements

This section describes the features of the application.

### Definition of MVP
The MVP of this project is to:
- Have a player sign-in with a username before he/she begins the game.
- Let two players play a game of checkers on web based on the American rules.
- Allow a player to resign from a game whenever he/she wants.

### MVP Features

#### Sign-in
The player sign-in is one feature of MVP where the player is able to sign-in with a username of his/her choice. The system validates whether or not the username is in use, and notifies the player if they need to choose a different username. If the username chosen is not in use, the system redirects the player to the game menu where the player can see a list of all players signed in.

#### Game View
The game view feature displays the 8x8 checkers board with the initial setup of pieces. Each player is given 12 discs, in either red or white color, and they are placed only on black squares.

#### Resignation
A player can sign-out from the application whenever he/she wants. Once the player signs out the username used by him/her is released and anyone can use that name. When a player signs-out during a game, the game is cancelled, and the opponent is notified. 

## Application Domain

This section describes the application domain.

### Overview of Major Domain Areas
We have implemented this domain model for our Web Checkers game implementation. The purpose of designing a domain model is to describe the abstractions in our proposed applications and to give a clear understanding of the system. The domain model proposed in sprint 1 has been updated to the domain model shown below. 

<img src="https://image.prntscr.com/image/BQVgonBnSt_Trjw06kc8Aw.png" alt="hi" class="inline"/>

### Details of each Domain Area
#### WebCheckersGame
Game has is the core to being able to play the game. Game has a player and an opponenent that are playing a game . Also, the game is played on a Board that is made of squares and that can contain disc. 

#### Pieces
Discs are moved by players and can be located on Squares. These discs will be draged and droped and can be turned into kings.

## Architecture

This section describes the application architecture.

### Summary
We are using Spark framework for our WebCheckers game implementation. Spark is a Java-based, web micro-framework which handles HTTP requests and delegates HTML generation to a template Engine. We are using FreeMarker template engine for this purpose. Some benefits of using FreeMarker is that it supports JSP tags, templates can be nested in it in run-time and it also supports JSON.

<img src="https://image.prntscr.com/image/3SKdG2QeR_Sd3JQidgpKMA.png" alt="hi" class="inline"/>

The package diagram shows the dependencies that each layer has. The UI layer uses spark, freemarker, css and JS to generate and manipulate the views that are presented to the users. Furthermore, the UI uses the model and the application layer to manipulate the state of the of the system.

### UI Layer
This layer has all the classes which govern the routing of the view for certain set of actions performed while playing the game.


### Model Layer
This layer has classes defined in the domain, which define the behavior of the game (or the rules for the game) along with all the components used for playing the game like discs, board, etc.

### Application Layer
This layer has the class which maintains the state of the game.

### Static models
### Class Diagram
The Class diagram gives the higher level view of our WebCheckers game.
<img src="<img width="428" alt="class diagram" src="https://user-images.githubusercontent.com/32232788/32869370-9942ba8a-ca44-11e7-80c3-5a9a34b2ab6b.PNG" />

### Dynamic models
#### State-Chart Diagrams
Begin game state-Chart
<img src="https://image.prntscr.com/image/nbWnyXboQWyEfzTfUah6xQ.png" alt="hi" class="inline"/>

Game Running state-Chart
<img src="https://image.prntscr.com/image/y1dSp38lSiq-IW2IM9NRoA.png" alt="hi" class="inline"/>

#### Sequence Diagram Diagrams
Create checkers Game 
<img src="https://image.prntscr.com/image/t1IZTkzuTKCcbJKSmEANBA.png" alt="hi" class="inline"/>

