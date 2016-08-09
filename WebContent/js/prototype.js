$("#keyWords").tagit({

	// Options
	fieldName : "keyWords",
//	 availableTags: ["c++", "java", "php", "javascript", "ruby", "python",
//	 "c"],
	availableTags : '@Session["keywordslist"]',

	autocomplete : {
		delay : 0,
		minLength : 1
	},
	showAutocompleteOnFocus : false,
	removeConfirmation : false,
	caseSensitive : false,
	allowDuplicates : false,
	allowSpaces : false,
	readOnly : false,
	tagLimit : null,
	singleField : true,
	singleFieldDelimiter : ',',
	singleFieldNode : null,
	tabIndex : null,
	placeholderText : null,

	// Events
	beforeTagAdded : function(event, ui) {
		console.log(ui.tag);
	},
	afterTagAdded : function(event, ui) {
		console.log(ui.tag);
	},
	beforeTagRemoved : function(event, ui) {
		console.log(ui.tag);
	},
	onTagExists : function(event, ui) {
		console.log(ui.tag);
	},
	onTagClicked : function(event, ui) {
		console.log(ui.tag);
	},
	onTagLimitExceeded : function(event, ui) {
		console.log(ui.tag);
	}

});