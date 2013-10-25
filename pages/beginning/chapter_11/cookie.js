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
	document.cookie.replace(/(\b[^=;]+)=([^;]+)/gi, function(sub, $1, $2){
		cookies[$1] = unescape($2);
		return;
	});
	return name ? cookies[name] : cookies;
}
