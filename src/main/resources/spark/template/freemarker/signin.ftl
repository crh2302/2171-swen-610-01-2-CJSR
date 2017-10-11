<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
  <title>${title} | Web Checkers</title>
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/game.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

</head>
  <body>
    <div class="page">

        <h1>Web Checkers</h1>

        <div class="navigation">
            <a href="/">my home</a>
            <a href="/signin">login</a>
        </div>

        ${loginMessage}<br /><br />

        <#if errorMessage??>
            ${errorMessage}
        </#if>

            <form action="/name" method="POST">
                <br/>
                  <input name="playerName" />
                <br/><br/>
                  <button type="submit">Submit Name</button>
            </form>

    </div>


  </body>
</html>
