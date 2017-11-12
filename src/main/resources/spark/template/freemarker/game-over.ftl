<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>

    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/game.css">

</head>
    <body>
        <div class="page">
            <h1>Web Checkers</h1>

            <div class="navigation">
                <a href="/game-menu?playerName=${playerName}&errorPathType=gameOver">my home</a>
                <a href="/?signedOut=${playerName}"> sign out [${playerName}] </a>
            </div>

            <div class="body">
                <form id="gameForm" action="/submitTurn" method="POST">

                    <p>
                        ${messageTitle}
                    </p>

                    <div>
                        <div id="game-controls">
                            <fieldset id="game-toolbar">
                                <legend>Controls</legend>
                                <div class="toolbar">
                                    <a href="#" id="backupLink" disabled=disabled
                                       title="Remove the last move with your current turn.">
                                        Backup one move
                                    </a>
                                    <a href="#" id="resetLink" disabled=disabled
                                       title="Remove all moves within your current turn.">
                                        Reset turn
                                    </a>
                                    <a href="#" id="submitLink" disabled=disabled
                                       title="Commit your current turn to the server.">
                                        Submit turn
                                    </a>
                                    <a href="#" id="resignLink" disabled=disabled
                                       title="End the game by resigning.">
                                        Resign from game
                                    </a>
                                </div> <!-- toolbar end -->
                            </fieldset>
                        </div> <!-- game controls end -->

                        <div class="game-board">
                            <p>
                                ${message}
                            </p>
                        </div> <!-- game-board end -->
                    </div> <!-- no class end -->
                </form> <!-- game form end -->
            </div> <!-- body end -->
        </div> <!-- page end -->

    </body>
</html>

