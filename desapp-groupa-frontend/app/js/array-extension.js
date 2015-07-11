Array.prototype.removeIfExist = function(element) {
var idx = this.indexOf(element);
	if (idx != -1) {
    	return this.splice(idx, 1);
	}
	return false;
}

Array.prototype.addIfNotExist = function(element) {
var idx = this.indexOf(element);
	if (idx == -1) {
    	return this.push(element);
	}
	return false;
}