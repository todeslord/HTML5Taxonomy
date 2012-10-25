<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>HTML5 Visualization</title>

<!-- CSS Files -->
<link type="text/css" href="Extras/base.css" rel="stylesheet" />
<link type="text/css" href="Extras/Sunburst.css" rel="stylesheet" />
<link type="text/css" href="Extras/menu.css" rel="stylesheet" />


<!--[if IE]><script language="javascript" type="text/javascript" src="Extras/excanvas.js"></script><![endif]-->

<!-- JIT Library File -->
<script language="javascript" type="text/javascript" src="Extras/jit.js"></script>

<!-- Example File -->
<script language="javascript" type="text/javascript" src="HTMLVisualisation.js"></script>
<script language="javascript" type="text/javascript" src="DataCategory.js"></script>


</head>

<body onload="init('category');">

<?php

include("navi.html");

?>

<div id="center-container">

    <div id="infovis"></div>    
</div>

<div id="right-container">

<p class="disappear">

We sorted the features according to their main aspect from our point of view.<br/>
The <b>data-category</b> includes all features regarding the storing, tagging and standardization of data.<br/>
The features giving an audio-visual output to the user are represented by the <b>visualization-category</b>.<br/>
On the opposite all features allowing user-input are allocated to the <b>access-category</b>. <br/>
The <b>communication-category</b> contains all features covering interaction between different programming-languages via web.			


</p>

<div id="inner-details"></div>

<!-- Footer unter right-container über CSS fixiert -->

<div id="footer">to rotate click left
<div id="source">Source: <a href="http://thejit.org/static/v20/Jit/Examples/Sunburst/example2.html" target="_new">thejit.org</a></div>

</div>



</div>

<div id="log"></div>



</div>
</body>
</html>
