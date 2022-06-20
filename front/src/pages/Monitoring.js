import Sidebar from "../components/nav-bar/nav_bar";
import VirtualizedList from "../components/VirtualizedList";
import { BarChart } from "../components/barChart";
import { Joystick } from "react-joystick-component";
import JoystickComp from "../components/joystick";
import LineChartMonitoring from "../components/lineChartMonitoring";
import Speedometer from "../components/clocks/speedometer";
import Direction from "../components/clocks/direction";
import VerticalSpeed from "../components/clocks/verticalSpeed";
import Height from "../components/clocks/height";
import Horizon from "../components/clocks/horizon";
import Turn from "../components/clocks/turn";
import { useState, useEffect } from "react";
import axios from "axios";

export default function Monitoring() {
  const [jasonObject, setJasonObject] = useState({});
  const [value, setValue] = useState("");
  const [speedometer, setSpeedometer] = useState(0);
  const [direction, setDirection] = useState(0);
  const [heigh, setHeigh] = useState(0);
  const [turn, setTurn] = useState(0);
  const [verticalSpeed, setVerticalSpeed] = useState(0);
  const [horizon, setHorizon] = useState(0);
  const [data, setData] = useState([0]);
  const [labels, setlabels] = useState(["start"]);
  const SET = (val) => {
    setValue(val);
  };
  const setClock = () => {
    setSpeedometer(jasonObject["airspeed-kt"]);
    setDirection(jasonObject["heading-deg"]);
    setHeigh(jasonObject["altimeter_indicated-altitude-ft"]);
    setTurn(jasonObject["roll-deg"]);
    setVerticalSpeed(jasonObject["vertical-speed-fps"]);
    setHorizon(jasonObject["attitude-indicator_internal-pitch-deg"]);
  };
  const setGr = () => {
    const x = jasonObject[value];
    if (x != undefined) {
      data.push(jasonObject[value]);
    }
    setlabels([...labels, data.length]);
    setData(data);
  };
  useEffect(() => {
    setClock();
    setGr();
  }, [value]);

  //interval for updating the data
  const getDataOfFlight = async () => {
    axios
      .get("/api/liveFlights/test")
      .then((res) => {
        setJasonObject(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };
  setInterval(() => {
  getDataOfFlight();
   setClock();
    setGr();
  }, 1000);

 
  return (
    <div>
      <Sidebar />
      <h1 style={{ position: "absolute", left: "40%", top: "10%" }}>
        {" "}
        Monitoring {value}
      </h1>
      <div style={{ backgroundColor: "white" }}>
        <div style={{ position: "absolute", left: "25%", top: "25%" }}>
          {/* <VirtualizedList setValue={SET} /> */}
        </div>
        <div
          style={{
            position: "absolute",
            left: "78%",
            right: "0%",
            top: "30%",
            width: "20vw",
          }}
        >
          {/* <h1>Joystick</h1> */}
          <JoystickComp />
          {/* <Joystick /> */}
        </div>
        <div
          style={{
            position: "absolute",
            left: "40%",
            top: "25%",
            width: "35vw",
          }}
        >
          <LineChartMonitoring data={data} labels={labels} />
        </div>
        <div
          style={{
            display: "grid",
            gridTemplateColumns: "auto auto auto",
            gap: "20px",
            padding: "10px",
            margin: "35px",
            position: "absolute",
            left: "35%",
            top: "60%",
            width: "35vw",
          }}
        >
          <b style={{ textAlign: "center" }}>
            Speed
            <Speedometer
              speedometer={speedometer}
              setSpeedometer={setSpeedometer}
            />{" "}
          </b>
          <b style={{ textAlign: "center" }}>
            Height
            <Height heigh={heigh} setHeigh={setHeigh} />{" "}
          </b>
          <b style={{ textAlign: "center" }}>
            Horizon
            <Horizon horizon={horizon} setHorizon={setHorizon} />{" "}
          </b>
          <b style={{ textAlign: "center" }}>
            Direction
            <Direction direction={direction} setDirection={setDirection} />{" "}
          </b>
          <b style={{ textAlign: "center" }}>
            Turn
            <Turn turn={turn} setTurn={setTurn} />{" "}
          </b>
          <b style={{ textAlign: "center" }}>
            Vertical speed
            <VerticalSpeed
              verticalSpeed={verticalSpeed}
              setVerticalSpeed={setVerticalSpeed}
            />{" "}
          </b>
        </div>
      </div>
    </div>
  );
}
