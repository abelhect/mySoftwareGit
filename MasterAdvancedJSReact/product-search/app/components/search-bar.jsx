var React = require('react');

//search bar enging
class SearchBar extends React.Component{

  handleQuery(event){
    this.props.onQuery(event.target.value);
  }

  render() {
    return(
      <div className="search-bar">
        <input type="text" onChange={this.handleQuery.bind(this)} placeholder="Search"/>
      </div>
    )

  }
}

module.exports = SearchBar;
