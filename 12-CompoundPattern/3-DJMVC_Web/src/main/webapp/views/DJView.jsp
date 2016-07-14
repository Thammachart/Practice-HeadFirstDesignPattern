<jsp:useBean id="beatModel" scope="request" class="org.dj.models.BeatModel" />
<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>DJ View</title>
  <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>
<body>
    <h1>DJ View</h1>
        Beats per minutes = <jsp:getProperty name="beatModel" property="BPM" />
    <br><hr><br>

    <form action="/servlet/djview" method="post">
        BPM: <input type="text" name="bpm" value="<jsp:getProperty name='beatModel' property='BPM'/>">

        <input type="submit" name="set" value="set">
        <br>
        <input type="submit" name="decrease" value="<<">
        <br>
        <input type="submit" name="increase" value=">>">
        <br>
        <input type="submit" name="on" value="on">
        <br>
        <input type="submit" name="off" value="off">
        <br>
    </form>
</body>
</html>
