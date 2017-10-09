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
      <a href="/">my home</a>
        <a href="/signin">login</a>
    </div>
    
    <div class="body">
      <p>Welcome to the world of online Checkers.</p>
    </div>

      <p> Sign in </p><br />
          <#if playerNames??>
              <ol>
                  <#list playerNames as n>
                      <li>${n}</li>
                  </#list>
              </ol>
          </#if>
    
  </div>
</body>
</html>
