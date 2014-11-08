// index.js

var REST_DATA = 'api/todolist';
var REST_ENV = 'api/dbinfo';
var KEY_ENTER = 13;
var defaultItems = [
	{name: 'A&F', serviceLine: 'AIS', numPlanRoles: '0', numNonInterlock: '4', numInterlock: '0', skillsRequired: 'Sterling, WCS, Java', numOfResources: '4'},
	{name: 'ATT', serviceLine: 'AMS', numPlanRoles: '5', numNonInterlock: '0', numInterlock: '0', skillsRequired: 'Sterling, WCS, Java', numOfResources: '5'}
];

function loadItems(){
	xhrGet(REST_DATA, function(data){
		document.getElementById("loading").innerHTML = "";
		
		var receivedItems = data.body || [];
		var items = [];
		var i;
		// Make sure the received items have correct format
		for(i = 0; i < receivedItems.length; ++i){
			var item = receivedItems[i];
			if(item && 'id' in item && 'name' in item){
				items.push(item);
			}
		}
		var hasItems = items.length;
		if(!hasItems){
			items = defaultItems;
		}
		for(i = 0; i < items.length; ++i){
			addItem(items[i], !hasItems);
		}
		if(!hasItems){
			var table = document.getElementById('notes');
			var nodes = []; 
			// push all cells into table
			for(i = 0; i < table.rows.length; ++i){ // need to change to a loop of all cells
				nodes.push(table.rows[i].firstChild.firstChild);
				nodes.push(table.rows[i].firstChild.nextSibling.firstChild); // push next cell TQ
				nodes.push(table.rows[i].firstChild.nextSibling.nextSibling.firstChild); // 
				nodes.push(table.rows[i].firstChild.nextSibling.nextSibling.nextSibling.firstChild);
				nodes.push(table.rows[i].firstChild.nextSibling.nextSibling.nextSibling.nextSibling.firstChild);
				nodes.push(table.rows[i].firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.firstChild);			
				nodes.push(table.rows[i].firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.firstChild);			
				
			}
			function save(){
				if(nodes.length){
					saveChange(nodes.shift(), save);
				}
			}
			save();
		}
	}, function(err){
		console.error(err);
		document.getElementById("loading").innerHTML = "ERROR";
	});
}

function addItem(item, isNew){
	var row = document.createElement('tr');

	var id = item && item.id;
	if(id){
		row.setAttribute('data-id', id);
	}
	
	// to-do: add multiple columns
	row.innerHTML = 
		"<td style='width:12%' id='nametd'><textarea onchange='saveChange(this)' onkeydown='onKey(event)'></textarea></td>" +
		"<td style='width:12%' id='servicelinetd'><textarea onchange='saveChange(this)' onkeydown='onKey(event)'>AIS</textarea></td>" +	
		"<td style='width:12%' id='rolestd'><textarea onchange='saveChange(this)' onkeydown='onKey(event)'>0</textarea></td>" +	
		"<td style='width:12%' id='noninterlocktd'><textarea onchange='saveChange(this)' onkeydown='onKey(event)'>0</textarea></td>" +	
		"<td style='width:12%' id='interlocktd'><textarea onchange='saveChange(this)' onkeydown='onKey(event)'>0</textarea></td>" +	
		"<td style='width:12%' id='skillstd'><textarea onchange='saveChange(this)' onkeydown='onKey(event)'>Java</textarea></td>" +	
		"<td style='width:12%' id='resourcetd'><textarea onchange='saveChange(this)' onkeydown='onKey(event)'>0</textarea></td>" +	
		"<td class='deleteBtn' onclick='deleteItem(this)' title='delete me'></td>";
	
	var table = document.getElementById('notes');
	console.log(table.lastChild);
	
	table.lastChild.appendChild(row);
	
	var textarea = row.firstChild.firstChild; 
	var textarea2 = row.firstChild.nextSibling.firstChild; // second
	var textarea3 = row.firstChild.nextSibling.nextSibling.firstChild; // second
	var textarea4 = row.firstChild.nextSibling.nextSibling.nextSibling.firstChild; // second
	var textarea5 = row.firstChild.nextSibling.nextSibling.nextSibling.nextSibling.firstChild; // second
	var textarea6 = row.firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.firstChild; // second
	var textarea7 = row.firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.firstChild; // second
	
	if(item){
		textarea.value = item.name;
	    textarea2.value = item.serviceLine;
	    textarea3.value = item.numPlanRoles;
	    textarea4.value = item.numNonInterlock;
	    textarea5.value = item.numInterlock;
	    textarea6.value = item.skillsRequired;
	    textarea7.value = item.numOfResources;
	}
	
	row.isNew = !item || isNew;
	textarea.focus();
}

function deleteItem(deleteBtnNode){
	var row = deleteBtnNode.parentNode;
	row.parentNode.removeChild(row);
	xhrDelete(REST_DATA + '?id=' + row.getAttribute('data-id'), function(){
	}, function(err){
		console.error(err);
	});
}

function onKey(evt){
	if(evt.keyCode == KEY_ENTER && !evt.shiftKey){
		evt.stopPropagation();
		evt.preventDefault();
		var row = evt.target.parentNode.parentNode;
		if(row.nextSibling){
			row.nextSibling.firstChild.firstChild.focus();
		}else{
			addItem();
		}
	}
}

function saveChange(contentNode, callback){
	var row = contentNode.parentNode.parentNode;
	
	// check contentNode cell, first cell for name, second cell for serviceLine
	var data = {
		//name: contentNode.value,
		name: row.firstChild.firstChild.value,
		//serviceLine: contentNode.value	
		serviceLine:     row.firstChild.nextSibling.firstChild.value,
		numPlanRoles:    row.firstChild.nextSibling.nextSibling.firstChild.value,
		numNonInterlock: row.firstChild.nextSibling.nextSibling.nextSibling.firstChild.value, 
		numInterlock:    row.firstChild.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.value,
		skillsRequired:  row.firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.value, 
		numOfResources:  row.firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.value	
	};
	
	if(row.isNew){
		delete row.isNew;
		xhrPost(REST_DATA, data, function(item){
			row.setAttribute('data-id', item.id);
			callback && callback();
		}, function(err){
			console.error(err);
		});
	}else{
		data.id = row.getAttribute('data-id');
		xhrPut(REST_DATA, data, function(){
			console.log('updated: ', data);
		}, function(err){
			console.error(err);
		});
	}
}

function toggleServiceInfo(){
	var node = document.getElementById('dbserviceinfo');
	node.style.display = node.style.display == 'none' ? '' : 'none';
}

function updateServiceInfo(){
	xhrGet(REST_ENV, function(dbinfo){

				console.log(dbinfo);
				document.getElementById('envServiceName').innerHTML = dbinfo.name;
				document.getElementById('envDbName').innerHTML = dbinfo.db;
				document.getElementById('envHost').innerHTML = dbinfo.host;
				document.getElementById('envPort').innerHTML = dbinfo.port;
				document.getElementById('envUrl').innerHTML = dbinfo.jdbcurl;


	}, function(err){
		console.error(err);
	});
}

updateServiceInfo();
loadItems();

