var TableTree = function() {
    var demo1 = function() {
        jQuery('#gtreetable').gtreetable({
            'draggable': true,
            'source':
                function(id) {
                //return '{"nodes":[{parent:0, "level":"1", "name":"Node -1-1", "id":"201508031529040.7272927564780152:1", "type":"folder"}, {"parent":"0", "level":"1", "name":"Node -1-2", "id":201508031529040.530707684975941:1, type:folder}, {parent:0, level:1, name:Node -1-3, id:201508031529040.9277757128843572:1, type:folder}, {parent:0, level:1, name:Node -1-4, id:201508031529040.2339819878771645:1, type:folder}, {parent:0, level:1, name:Node -1-5, id:201508031529040.39825803169261764:1, type:folder}]}'
                return {
                    type: 'GET',
                    url: '/platform/tabletree',
                    data: {
                        'id': id
                    },
                    dataType: 'json',
                    error: function(XMLHttpRequest) {
                        alert(XMLHttpRequest.status + ': ' + XMLHttpRequest.responseText);
                    }
                }
            },
            'sort': function (a, b) {          
                var aName = a.name.toLowerCase();
                var bName = b.name.toLowerCase(); 
                return ((aName < bName) ? -1 : ((aName > bName) ? 1 : 0));                            
            },
            'types': { default: 'glyphicon glyphicon-folder-open', folder: 'glyphicon glyphicon-folder-open'},
            'inputWidth': '255px'
        });
    }

    return {
        //main function to initiate the module
        init: function() {
            demo1();
        }
    };
}();