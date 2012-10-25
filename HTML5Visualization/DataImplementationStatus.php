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
<script language="javascript" type="text/javascript" src="DataImplementationStatus.js"></script>


</head>

<body onload="init('implementationStatus');">

<?php

include("navi.html");

?>

<div id="center-container">

    <div id="infovis"></div>    
</div>

<div id="right-container">

<p class="disappear">

This view sorts the features according to how far they are implemented in different browsers as categorized by the WhatWG. We added in the wild and the status for those features not covered by WhatWG. The highest level is implemented, followed by heavy testing, in the wild and not implemented.<br/> 
<b>Implemented</b> features have passed all possible test-cases and are running in all browsers.<br/>
If there are not covered test-cases the feature belongs to the <b>heavy-testing-category</b>.<br/>
<b>In the wild</b> are those features for which there are implementations in the web but they are not yet in heavy testing mode regarding WhatWG.

	


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
