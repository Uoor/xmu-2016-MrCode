function addCookie(name,value){
		var cookieString = name + "=" + escape(value); 
		var expireDay = 30;		
    var date = new Date();
    date.setTime(date.getTime + expireDay*3600*1000*24); 
    cookieString = cookieString + "; expire=" + date.toGMTString(); 
		document.cookie = cookieString; 
}

function getCookie(cookie_name){ 
    var results = document.cookie.match('(^|;) ?' + cookie_name + '=([^;]*)(;|$)'); 
    
    if (results) 
        return (unescape(results[2])); 
    else 
        return null; 
}