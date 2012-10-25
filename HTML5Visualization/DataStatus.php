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
<script language="javascript" type="text/javascript" src="DataStatus.js"></script>


</head>

<body onload="init('sameStatus');">

<?php

include("navi.html");

?>

<div id="center-container">

    <div id="infovis"></div>    
</div>

<div id="right-container">

<p class="disappear">

According to the W3C "The W3C technical report development process is the set of steps and requirements followed by W3C Working Groups to standardize Web technology."
This view displays the three steps being essential in our point of view.<br/>
The first step in specification-process is the <b>Working Draft</b>. A Working Group is frequently updating the specification.<br/>
After the <b>Working</b> Draft the specification becomes Candidate Recommendation Status. In this step public review is expected.<br/>
<b>Recommendation</b> is the final status. W3C reached consensus that this specification should be implemented.<br/>
	


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
