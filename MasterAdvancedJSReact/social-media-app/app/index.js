var person = {
    name: 'Hector Martinez',
    location: 'Tampa, FL',
    occupation: {
      title: 'Saving the world',
      employer: '@CBORGTECH LLC'
    },
    photo: 'images/superPapo.png',
    updates: [
      {
        platform: 'twitter',
        status: 'I\'m happy, hope you\'re too!'
      },
      {
        platform: 'twitter',
        status: 'Fear makes the wolf look bigger!'
      },
      {
        platform: 'facebook',
        status: 'If you break it, you buy it!'
      }
    ]
  }

  class Updates extends React.Component{

    updates() {

        return this.props.updates.map(function(update, index){
            return (
              <li className={"update " + update.platform} key={index}>
              {update.status}
              </li>
            )
        });

    }


    render(){
      return(
        <div className="updates">
          <ul>
            {this.updates()}
          </ul>
        </div>
      )
    }
  }

  class Bio extends React.Component{
    render(){
      return(
        <div className="bio">
          <h1 className="name">{this.props.name}</h1>
          <h2 className="location">{this.props.location}</h2>
          <div className="occupation">
            <p>{this.props.occupation}</p>
          </div>
        </div>
      )
    }
  }

  class Photo extends React.Component{
    render(){
      return(
        <div className="photo">
          <img src={this.props.photo} alt="Photo"/>
        </div>
      )
    }
  }

  class Card extends React.Component{
    render(){

      return(
        <div className="card">
          <Photo photo={person.photo}/>
          <Bio  name={person.name} location={person.location}
                occupation={person.occupation.title + " " + person.occupation.employer}/>
          <Updates updates={person.updates}/>
        </div>
      )
    }
  }

ReactDOM.render(
  <Card/>,
document.getElementById('app')
);
