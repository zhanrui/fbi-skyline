var UITree = function () {
    var contextualMenuSample = function() {
        $("#tree").jstree({
            "core" : {
                "themes" : {
                    "responsive": false
                }, 
                // so that create works
                "check_callback" : true,
                'data':{
                    'url' : function (node) {
                        return '/platform/tree';
                    },
                    'data' : function (node) {
                        //alert("---"+JSON.stringify(node));
                        return {'node':JSON.stringify(node) ,'parentId' : node.id };
                    }
                }
                //[{"children":[{"children":[{"icon":"fa fa-file icon-state-info","text":"Node-1-1"}, {"icon":"fa fa-file icon-state-info", "text":"Node-1-2"}, {"icon":"fa fa-file icon-state-info", "text":"Node-1-3"}], "text":"Node-1"}], "text":"Parent Node"}]
            },
            "types" : {
                "default" : {
                    "icon" : "fa fa-folder icon-state-warning icon-lg"
                },
                "file" : {
                    "icon" : "fa fa-file icon-state-warning icon-lg"
                }
            },
            "state" : { "key" : "demo" },
            "plugins" : [ "contextmenu", "dnd", "state", "types" ]
        });
    
    }
    return {
        //main function to initiate the module
        init: function () {
            contextualMenuSample();
        }
    };
}();