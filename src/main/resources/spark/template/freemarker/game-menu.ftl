<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
  <div class="page">
  
    <h1>Web Checkers</h1>
    
    <div class="navigation">
      <a href="/game-menu?playerName=${playerName}&errorPathType=none">my home</a>
        <a href="/signout?playerName=${playerName}"> sign out [${playerName}] </a>
    </div>                                                       
    
    <div class="body">
      Welcome to the Game Menu of WebCheckers, <#if playerName??>${playerName}</#if>!
    </div><br />

      <form action="/opponent?playerName=${playerName}" method="POST">
          Enter the name of your desired opponent:
          <br />
          <input name="opponent" />
          <button type="submit">Submit Opponent</button>
      </form>

      <div>
          <#if opponentError??>
              ${opponentError}
          </#if>
      </div>

      <#if playerNames??>
      <br />
      Online Players:
      <br />
          <ol>
              <#list playerNames as n>
                  <#if n != playerName><li> ${n} </li>
                  <#else>
                    <li>${n} [this is you]</li>
                  </#if>
              </#list>
          </ol>
      </#if>
  </div>
</body>
</html>
