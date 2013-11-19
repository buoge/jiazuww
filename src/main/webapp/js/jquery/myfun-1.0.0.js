jQuery.fn.extend({
	serializeJson: function(){
		var json = {};
		var arr = this.serializeArray();
		var len = arr.length;
		for ( var i = 0; i < len; i++) {
			var item = arr[i];
			json[item.name] = item.value;
		}
		return json;
	}
});