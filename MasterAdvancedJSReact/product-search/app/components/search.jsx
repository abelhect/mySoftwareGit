var React = require('react');
var SearchBar = require('./search-bar.jsx');
var Results = require('./results.jsx');
const image = require('../img/product-search.ico');

//main class housing everything
class Search extends React.Component{
  constructor(props){
    super(props);
    this.state = {
      query: ''
    };
  }

  handleQuery(query){
    this.setState({'query': query.toLowerCase().trim()})
  }

  render(){
    return(
      <div className="search">
        <div className="logo">
          <img src={image} alt="Logo Here" className="logo"/>
        </div>
        <div className='title'>
          Product Search
        </div>
        <SearchBar onQuery={this.handleQuery.bind(this)}/>
        <Results products={this.props.products} query={this.state.query}/>
      </div>
    )
  }
}

module.exports = Search;
