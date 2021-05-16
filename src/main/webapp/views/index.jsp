<html>
<head><title>Yay</title></head>
<body>
<br>standard prerendered text<br>
${somethingElse}
<br>
<br>
<br>read input via @ModelAttribute<br>
<form action="sendVals" method="post">
    Enter text : <input type="text" name="text1"><br>
    Enter num : <input type="number" name="num1"><br>
    <input type="submit">
</form>

<br>read input via ModelAndView object use. ALSO SAVES ALIEN<br>
<form action="alienate" method="post">
    Enter id : <input type="number" name="id2"><br>
    Enter name : <input type="text" name="name2"><br>
    <input type="submit">
</form>


<br>read input via @ModelAttribute<br>
<form action="alienationWithStyle" method="post">
    Enter id : <input type="number" name="id"><br>
    Enter name : <input type="text" name="name"><br>
    <input type="submit">
</form>

<br>findaliens<br>
<form action="findAliens" method="get">
    Enter id : <input type="number" name="id3"><br>
    <input type="submit">
</form>

<br>find alien by name<br>
<form action="findAlienByName" method="get">
    Enter name : <input type="text" name="name3"><br>
    <input type="submit">
</form>
<br>find alien with id bigger than the one entered<br>
<form action="findAlienWithBiggerId" method="get">
    Enter id : <input type="number" name="id4"><br>
    <input type="submit">
</form>
</body>
</html>