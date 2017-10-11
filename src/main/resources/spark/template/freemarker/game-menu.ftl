<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
  <div class="page">
  
    <h1>Web Checkers</h1>
    
    <div class="navigation">
      <a href="/game-menu">my home</a>
        <a href="/signout?playerName=${playerName}"> sign out [${playerName}] </a>
    </div>                                                       
    
    <div class="body">
      <p>Welcome to the Game Menu of WebCheckers, <#if playerName??>${playerName}</#if>!</p>
    </div>

      <div>
          <#if opponentError??>
              ${opponentError}
          </#if>
      </div>

      <#if playerNames??>
          <ol>
              <#list playerNames as n>
                  <#if n != playerName><li><a href="/opponent?opponent=${n}&playerName=${playerName}"> ${n} </a></li>
                  <#else>
                    <li>${n} [this is you]</li>
                  </#if>
              </#list>
          </ol>
      </#if>
  </div>
</body>
</html>
