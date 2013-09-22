(function(){
  $(document).ready(function() {
    $(document)
      .on('new-ng-state', function(event, data) {
        addNGMessages( data )
    })
  });
  function getScope() {
    var e = document.getElementById( 'road' );
    return angular.element( e ).scope();
  }
  /*function that add messages to our model*/
  function addNGMessages( message ) {
    var scope = getScope();
    scope.$apply(function(){
      scope.segments = message
    });
  }
})();