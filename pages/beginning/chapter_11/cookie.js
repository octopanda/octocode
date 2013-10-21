function setCookie(name, value, expires, path){
	value = escape(value);
	if(!expires){
		var now = new Date();
		now.setMonth(now.getMonth() + 6);
		expires = now.toUTCString();
	}
	path = path ? ";path=" + path : "";
	document.cookie = name + "=" + value + ";expires=" + expires + path;
}

function getCookie(name){
	var cookies = {};
	var matchs = document.cookie.match(/\b[^=;]+=[^;]+/gi);
	if(matchs <= 0) {
		return null;
	}
	for(var i = 0; i < matchs.length; i++){
		var item = matchs[i].split("=");
		cookies[item[0]] = item[1];
	}
	if(name){
		return cookies[name];
	}
	return cookies;
}
getCookie();