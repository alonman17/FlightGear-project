
import React from 'react'
import './App.css';
import LandingPage from './pages/landpage';
import Teleoperation from './pages/Teleoperation';
import TimeCapsule from './pages/Time_capsule';
import Monitoring from './pages/Monitoring';
import FleetOverview from './pages/Fleet_overview';

import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

//------------------------------------------------IMPORTS VIEWS-----------------------------------------------

//------------------------------------------------CLASS APP-----------------------------------------------
class App extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <Router>
        <Routes>
          <Route exact path="/" element={<LandingPage />} />
          <Route exact path="/Time_capsule" element={<TimeCapsule />} />
          <Route exact path="/teleoperation" element={<Teleoperation />} />
          <Route exact path="/fleet_overview" element={<FleetOverview />} />
          <Route exact path="/monitoring" element={<Monitoring />} />
        </Routes>
      </Router>
    );
  }
}
export default App;
// export default App;

  // return (
  //   <BrowserRouter>
  //   <div> hello</div>
  //     <Switch>
  //             <Route exact path='/' component={<LandingPage />} />
  //             {/* <Route path='/contact' component={Contact} />
  //             <Route path='/about' component={About} /> */}
  //         </Switch>
  
  // </BrowserRouter>
    // <Router>
    //   <div className="centered_layout">

  
       

    //         <Route path="/" exact>
    //           <LandingPage />
    //         </Route>
            

    //   </div>
   // </Router>
    // <div> 
    //      <Router>
      
   
    //      <Route path="" element={<LandingPage />} />
    //   <Route path="fleet_overview" element={<FleetOverview />} />

    //    </Router>
    //     </div>
  //);
// }

// export default App;
