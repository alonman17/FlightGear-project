import Sidebar from "../components/nav-bar/nav_bar";
// import VirtualizedList from "../components/VirtualizedList";
import { BarChart } from "../components/barChart";
import JoystickComp from "../components/joystick";
import LineChartMonitoring from "../components/lineChartMonitoring";
import Speedometer from "../components/clocks/speedometer";
import Direction from "../components/clocks/direction";
import VerticalSpeed from "../components/clocks/verticalSpeed";
import Height from "../components/clocks/height";
import Horizon from "../components/clocks/horizon";
import Turn from "../components/clocks/turn";
import { useState, useEffect } from "react";
import DiscreteSlider from "../components/videoSlider";
import LongMenu from "../components/speedButton";
import OnlyPlayPauseButton from "../components/playButton";
import ComplitedFlightsList from "../components/compledFlightsList";
import { Joystick } from "react-joystick-component";
import axios from "axios";

export default function TimeCapsule() {
  const [val, setVal] = useState(0);
  const [speed, setSpeed] = useState(0);
  const [isPlaying, setIsPlaying] = useState(false);
  const [value, setValue] = useState("");
  const [speedometer, setSpeedometer] = useState(0);
  const [direction, setDirection] = useState(0);
  const [heigh, setHeigh] = useState(0);
  const [turn, setTurn] = useState(0);
  const [verticalSpeed, setVerticalSpeed] = useState(0);
  const [horizon, setHorizon] = useState(0);
  const [data, setData] = useState([0]);
  const [labels, setlabels] = useState(["start"]);
  const [id, setId] = useState(0);
  const [jasonObject, setJasonObject] = useState({});
  const SetID = (id) => {
    setId(id);
  };
  const SET = (value) => {
    setValue(value);
  };
  // const setClock = () => {
  //   // setSpeedometer(allFlight[0].airspeedKt);
  //   setDirection(fakeData["heading-deg"]);
  //   setHeigh(fakeData["altimeter_indicated-altitude-ft"]);
  //   setTurn(fakeData["roll-deg"]);
  //   setVerticalSpeed(fakeData["vertical-speed-fps"]);
  //   setHorizon(fakeData["attitude-indicator_internal-pitch-deg"]);
  // };
  // const setGr = () => {
  //   const x = fakeData[value];
  //   if (x != undefined) {
  //     data.push(fakeData[value]);
  //   }
  //   setlabels([...labels, data.length]);
  //   setData(data);
  // };
  // useEffect(() => {
  //   setClock();
  //   setGr();
  // }, [value]);

  //interval for updating the data
  // axios
  //   .get("/api/liveFlights/test")
  //   .then((res) => {
  //     console.log(res.data);
  //   })
  //   .catch((err) => {
  //     console.log(err);
  //   });

  function otomaticSlider() {
    const time = setInterval(() => {
      if (isPlaying) {
        setVal((val + 0.05) * speed);
      }
      // if (val >= 0.5) {
      //   console.log(val);
      //   clearInterval(time);
      // }
      clearInterval(time);
    }, 500);
  }

  otomaticSlider();

  return (
    <div>
      <Sidebar />
      <h1 style={{ position: "absolute", left: "40%", top: "10%" }}>
        {" "}
        Time Capsule{value}
      </h1>
      <Sidebar />
      <div style={{ backgroundColor: "white" }}>
        <div style={{ position: "absolute", left: "25%", top: "25%" }}>
          {/* <VirtualizedList setValue={SET} /> */}
        </div>

        <div style={{ position: "absolute", left: "10.5%", top: "25%" }}>
          <h3>Completed flights</h3>
          <ComplitedFlightsList setId={SetID} />
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
            />
          </b>
        </div>
        <div>
          <DiscreteSlider val={val} setVal={setVal} />
        </div>
        <div
          style={{
            backgroundColor: "#1e90ff",
            position: "absolute",
            left: "35%",
            top: "16%",
          }}
        >
          <LongMenu speed={speed} setSpeed={setSpeed} />
        </div>
        <div
          style={{
            backgroundColor: "#1e90ff",

            position: "absolute",
            left: "40%",
            top: "16%",
          }}
        >
          <OnlyPlayPauseButton
            isPlaying={isPlaying}
            setIsPlaying={setIsPlaying}
          />
        </div>
      </div>
    </div>
  );
}
