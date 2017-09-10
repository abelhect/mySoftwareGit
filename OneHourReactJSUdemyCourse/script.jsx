// Code goes here

var Hello = React.createClass({
  render: function(){
    return(
          <h1>What's up React? Hola de Hector</h1>
      );
  }
});

React.render(<Hello/>, document.getElementById("root"));
