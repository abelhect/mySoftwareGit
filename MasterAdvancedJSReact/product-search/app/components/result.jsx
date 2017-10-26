var React = require('react');

//html place for displaying the Results
class Result extends React.Component{

  render() {
    return(
      <div className="in-stock">
        <h2><a href="#">{this.props.product.name}</a></h2>
        <p>${this.props.product.price/100.00}</p>
        <p>{this.props.product.description}</p>
      </div>
    )
  }
}

module.exports = Result;
