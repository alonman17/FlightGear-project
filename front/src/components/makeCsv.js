const fs = require("fs");
const csvToObj = require("csv-to-js-parser").csvToObj;

const data = fs.readFileSync("normal_flight.csv").toString();

const description = {
  aileron: { type: "number", group: 1 },
  elevator: { type: "number", group: 1 },
  rudder: { type: "number", group: 1 },
  "engine-pump": { type: "number", group: 1 },
  "engine-pump2": { type: "number", group: 1 },
  "external-power": { type: "number", group: 1 },
  "APU-generator": { type: "number", group: 1 },
  "latitude-deg": { type: "number", group: 1 },
  "longitude-deg": { type: "number", group: 1 },
  "altitude-ft": { type: "number", group: 1 },
  "roll-deg": { type: "number", group: 1 },
  "pitch-deg": { type: "number", group: 1 },
  "heading-deg": { type: "number", group: 1 },
  "side-slip-deg": { type: "number", group: 1 },
  "airspeed-kt": { type: "number", group: 1 },
  glideslope: { type: "number", group: 1 },
  "vertical-speed-fps": { type: "number", group: 1 },
  "airspeed-indicator_indicated-speed-kt": { type: "number", group: 1 },
  "altimeter_indicated-altitude-ft": { type: "number", group: 1 },
  "attitude-indicator_indicated-pitch-deg": { type: "number", group: 1 },
  "attitude-indicator_indicated-roll-deg": { type: "number", group: 1 },
  "attitude-indicator_internal-pitch-deg": { type: "number", group: 1 },
  "attitude-indicator_internal-roll-deg": { type: "number", group: 1 },
  "encoder_indicated-altitude-ft": { type: "number", group: 1 },
  "encoder_pressure-alt-ft": { type: "number", group: 1 },
  "gps_indicated-altitude-ft": { type: "number", group: 1 },
  "gps_indicated-ground-speed-kt": { type: "number", group: 1 },
  "gps_indicated-vertical-speed": { type: "number", group: 1 },
  "indicated-heading-deg": { type: "number", group: 1 },
  "magnetic-compass_indicated-heading-deg": { type: "number", group: 1 },
  "slip-skid-ball_indicated-slip-skid": { type: "number", group: 1 },
  "vertical-speed-indicator_indicated-speed-fpm": { type: "number", group: 1 },
  engine_rpm: { type: "number", group: 1 },
};
let obj = csvToObj(data, ",", description);
const json = JSON.stringify(obj, null, " ");
fs.writeFileSync("data.json", json);
