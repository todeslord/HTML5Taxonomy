var labelType, useGradients, nativeTextSupport, animate;

(function() {
  var ua = navigator.userAgent,
      iStuff = ua.match(/iPhone/i) || ua.match(/iPad/i),
      typeOfCanvas = typeof HTMLCanvasElement,
      nativeCanvasSupport = (typeOfCanvas == 'object' || typeOfCanvas == 'function'),
      textSupport = nativeCanvasSupport 
        && (typeof document.createElement('canvas').getContext('2d').fillText == 'function');
  //I'm setting this based on the fact that ExCanvas provides text support for IE
  //and that as of today iPhone/iPad current text support is lame
  labelType = (!nativeCanvasSupport || (textSupport && !iStuff))? 'Native' : 'HTML';
  nativeTextSupport = labelType == 'Native';
  useGradients = nativeCanvasSupport;
  animate = !(iStuff || !nativeCanvasSupport);
})();

var Log = {
  elem: false,
  write: function(text){
    if (!this.elem) 
      this.elem = document.getElementById('log');
    this.elem.innerHTML = text;
    this.elem.style.left = (500 - this.elem.offsetWidth / 2) + 'px';
  }
};


function init(sortingElement){
  //init data
  if(sortingElement == "category"){
	  var json = getJsonCategory();
  }else if(sortingElement == "implementationStatus"){
	  var json = getJsonImplementationStatus();
  }else if(sortingElement == "orientation"){
	  var json = getJsonOrientation();
  }else if(sortingElement == "sameSpec"){
	  var json = getJsonSameSpec();
  }else if(sortingElement == "sameStatus"){
	  var json = getJsonStatus();
  }else if(sortingElement == "statusImplementationStatus"){
	  sortingElement = "implementationStatus";
	  var json = getJsonStatusImplementationStatus();
  
  }else{
	  alert("Wrong ParameterError, function init, thrown by Jan");
  }
    //end
    //init Sunburst
    var sb = new $jit.Sunburst({
        //id container for the visualization
        injectInto: 'infovis',
        //Distance between levels
        levelDistance: 90,
        //Change node and edge styles such as
        //color, width and dimensions.
        Node: {
          overridable: true,
          type: useGradients? 'gradient-multipie' : 'multipie'
        },
        //Select canvas labels
        //'HTML', 'SVG' and 'Native' are possible options
        Label: {
          type: labelType
        },
        //Change styles when hovering and clicking nodes
        NodeStyles: {
          enable: true,
          type: 'Native',
          stylesClick: {
            'color': '#33dddd'
          },
          stylesHover: {
            'color': '#dd3333'
          }
        },
        //Add tooltips
        Tips: {
          enable: true,
          onShow: function(tip, node) {
            var html = "<div class=\"tip-title\">" + node.name + "</div>"; 
            var data = node.data;
            if("shortDescription" in data) {
              html += data.shortDescription;
            }
            tip.innerHTML = html;
          }
        },
        //implement event handlers
        Events: {
          enable: true,
          onClick: function(node) {
            if(!node) return;
            //Build detailed information about the file/folder
            //and place it in the right column.

		//Done: - baue Ordnerstruktur fürs Auslesen der Kategorien!!!
		//Done: - einbauen, dass Link zu WHATWG/W3C im neuen Fenster geöffnet wird


		//Header
            var html = "<h2>" + node.name + "</h2>", data = node.data;

		//if data for header are inserted, read link etc.		

            if("true" == data.feature){

		//ToDO: - insert short description as well, and implement the long one, as a version sliding in, when you click the short one
            	html += data.longDescription;

		//Done: - Wenn Link nicht vorhanden, dann entsprechende Ausgabe
		if (data.w3cLink != '-'){
                html += "<p><a href=\""+data.w3cLink+"\" target=\_\"new\">Link to W3C<a></p>";
		}
		else {html +="<p>no link to W3C, because its not handled there</p>";}
                if (data.whatwgLink != '-'){
   		html += "<p><a href=\""+data.whatwgLink+"\" target=\_\"new\">Link to WHATWG<a></p>";
		}
		else {html +="<p>no link to WhatWG, because its not handled there</p>";}
                html += "<p><b>referencing Version from: </b>"+data.date+"</p>";

		//Done: have it illustrated as table
		//ToDO: - optimize table by using css
		//Done: - Category (data.category) and Orientation (data.orientation) are missing, because already visualized in the diagram
		//Done: - insert into table!?
		//Done: - specify by color
		//Done: - define table per CSS
		//Done: - switch bold/not bold
		html += "<table>";
                html += "<tr><td><b>Implementation Status</b></td><td class=\""+data.implementationStatus+"\"> "+data.implementationStatus+"</td></tr>";
 html += "<tr><td><b>Category</b></td><td class=\""+data.category+"\"> "+data.category+"</td></tr>";
 html += "<tr><td><b>Orientatiion</b></td><td class=\""+data.orientation+"\"> "+data.orientation+"</td></tr>";
                html += "<tr><td><b>W3C has the same specification as WhatWG</b></td><td> "+data.sameSpec+"</td></tr>";
                html += "<tr><td><b>W3C-Status</b></td><td class=\""+data.status+"\">"+data.status+"</td></tr>";
		html += "</table>";
            }else{
            	html += data.description;
            }
            
            $jit.id('inner-details').innerHTML = html;
            //hide tip
            sb.tips.hide();
            //rotate
            sb.rotate(node, animate? 'animate' : 'replot', {
              duration: 1000,
              transition: $jit.Trans.Quart.easeInOut
            });
          }
        },
        // Only used when Label type is 'HTML' or 'SVG'
        // Add text to the labels. 
        // This method is only triggered on label creation
        onCreateLabel: function(domElement, node){
          var labels = sb.config.Label.type,
              aw = node.getData('angularWidth');
          if (labels === 'HTML' && (node._depth < 2 || aw > 2000)) {
            domElement.innerHTML = node.name;
          } else if (labels === 'SVG' && (node._depth < 2 || aw > 2000)) {
            domElement.firstChild.appendChild(document.createTextNode(node.name));
          }
        },
        // Only used when Label type is 'HTML' or 'SVG'
        // Change node styles when labels are placed
        // or moved.
        onPlaceLabel: function(domElement, node){
          var labels = sb.config.Label.type;
          if (labels === 'SVG') {
            var fch = domElement.firstChild;
            var style = fch.style;
            style.display = '';
            style.cursor = 'pointer';
            style.fontSize = "0.8em";
            fch.setAttribute('fill', "#fff");
          } else if (labels === 'HTML') {
            var style = domElement.style;
            style.display = '';
            style.cursor = 'pointer';
            style.fontSize = "0.8em";
            style.color = "#ddd";
            var left = parseInt(style.left);
            var w = domElement.offsetWidth;
            style.left = (left - w / 2) + 'px';
          }
        }
   });
    //load JSON data.
    sb.loadJSON(json);
    //compute positions and plot.
    sb.refresh();
    //end
}
