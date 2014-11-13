<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<!DOCTYPE html>
<html>
<head>
  <@tiles.insertAttribute name="header"/>
</head>
<body>
  <@tiles.insertAttribute name="navigator"/>
  <@tiles.insertAttribute name="body"/>
  <@tiles.insertAttribute name="footer"/>
</body>
</html>