 function addItems() {
     var ai = document.getElementById("availableItems"); 
    var si = document.getElementById("selectedItems"); 
    for (i=0;i<ai.options.length;i++) { 
      if (ai.options[i].selected) { 
        var opt = ai.options[i]; 
        si.options[si.options.length] = new Option(opt.innerHTML, opt.value); 
        ai.options[i] = null; i = i - 1; 
      } 
    } 
  } 

  function addAll() { 
    var ai = document.getElementById("availableItems"); 
    var si = document.getElementById("selectedItems"); 
    for (i=0;i<ai.options.length;i++) { 
      var opt = ai.options[i]; 
      si.options[si.options.length] = new Option(opt.innerHTML, opt.value); 
    } 
    ai.options.length = 0; 
  } 

  function removeItems() {
    var ai = document.getElementById("availableItems"); 
    var si = document.getElementById("selectedItems"); 
    for (i=0;i<si.options.length;i++) { 
      if (si.options[i].selected) { 
        var opt = si.options[i]; 
        ai.options[ai.options.length] = new Option(opt.innerHTML, opt.value); 
        si.options[i] = null; i = i - 1; 
      } 
    } 
    sortAvailable(); 
  } 

  function removeAll() { 
    var ai = document.getElementById("availableItems"); 
    var si = document.getElementById("selectedItems"); 
    for (i=0;i<si.options.length;i++) { 
      var opt = si.options[i]; 
      ai.options[ai.options.length] = new Option(opt.innerHTML, opt.value); 
    } 
    si.options.length = 0; 
    sortAvailable(); 
  } 

  function moveUp() { 
      var si = document.getElementById("selectedItems"); 
      var sel = si.selectedIndex; 
      if (sel > 0) { 
        var optHTML = si.options[sel].innerHTML; 
        var optVal = si.options[sel].value; 
        var opt1HTML = si.options[sel-1].innerHTML; 
        var opt1Val = si.options[sel-1].value; 
        si.options[sel] = new Option(opt1HTML,opt1Val); 
        si.options[sel-1] = new Option(optHTML,optVal); si.options.selectedIndex = sel -1; 
    } 
  } 

  function moveDown() { 
    var si = document.getElementById("selectedItems"); 
    var sel = si.selectedIndex; 
    if (sel < si.options.length -1) { 
      var optHTML = si.options[sel].innerHTML; 
      var optVal = si.options[sel].value; 
      var opt1HTML = si.options[sel+1].innerHTML; 
      var opt1Val = si.options[sel+1].value; 
      si.options[sel] = new Option(opt1HTML,opt1Val); 
      si.options[sel+1] = new Option(optHTML,optVal); 
      si.options.selectedIndex = sel +1; 
    } 
  } 

  function sortAvailable() { 
    var ai = document.getElementById("availableItems"); 
    var tmp = ""; 
    for (i=0;i<ai.options.length;i++) { 
      if (tmp > "") tmp +=","; 
      tmp += ai.options[i].innerHTML + "~" + ai.options[i].value; 
    } 
    var atmp = tmp.split(",");
    atmp = atmp.sort(); 
    ai.options.length = 0;
    for (i=0;i<atmp.length;i++) { 
      var opt = atmp[i].split("~"); 
      ai.options[i] = new Option(opt[0],opt[1]); 
    } 
  } 
  function selectAllOptions(obj) {
	//  alert(obj);
	 // if (!hasOptions(obj)) { return; }
	  for (var i=0; i<obj.options.length; i++) {
	      obj.options[i].selected = true;
	      }
	  }

  /* function frmSubmit() {
    var si = document.getElementById("selectedItems"); 
    for (i=0;i<si.options.length;i++) { si.options[i].selected = true; } 
    document.form1.submit(); }  */