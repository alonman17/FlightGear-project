package com.flightgearserver.Http.Entiteis;

import javax.persistence.*;

@Entity
@Table(name = "flightdata")
public class Flightsdatum {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "flightid", nullable = false)
    private int flightid;

    @Column(name = "\"timestamp\"", nullable = false)
    private Long timestamp;

    @Column(name = "aileron")
    private Double aileron;

    @Column(name = "elevator")
    private Double elevator;

    @Column(name = "rudder")
    private Double rudder;

    @Column(name = "flaps")
    private Double flaps;

    @Column(name = "slats")
    private Double slats;

    @Column(name = "speedbrake")
    private Double speedbrake;

    @Column(name = "throttle0")
    private Double throttle0;

    @Column(name = "throttle1")
    private Double throttle1;

    @Column(name = "engine_pump0")
    private Double enginePump0;

    @Column(name = "engine_pump1")
    private Double enginePump1;

    @Column(name = "electric_pump0")
    private Double electricPump0;

    @Column(name = "electric_pump1")
    private Double electricPump1;

    @Column(name = "external_power")
    private Double externalPower;

    @Column(name = "apu_generator")
    private Double apuGenerator;

    @Column(name = "latitude_deg")
    private Double latitudeDeg;

    @Column(name = "longitude_deg")
    private Double longitudeDeg;

    @Column(name = "altitude_ft")
    private Double altitudeFt;

    @Column(name = "roll_deg")
    private Double rollDeg;

    @Column(name = "pitch_deg")
    private Double pitchDeg;

    @Column(name = "heading_deg")
    private Double headingDeg;

    @Column(name = "side_slip_deg")
    private Double sideSlipDeg;

    @Column(name = "airspeed_kt")
    private Double airspeedKt;

    @Column(name = "glideslope")
    private Double glideslope;

    @Column(name = "vertical_speed_fps")
    private Double verticalSpeedFps;

    @Column(name = "airspeed_indicator_indicated_speed_kt")
    private Double airspeedIndicatorIndicatedSpeedKt;

    @Column(name = "altimeter_indicated_altitude_ft")
    private Double altimeterIndicatedAltitudeFt;

    @Column(name = "altimeter_pressure_alt_ft")
    private Double altimeterPressureAltFt;

    @Column(name = "attitude_indicator_indicated_pitch_deg")
    private Double attitudeIndicatorIndicatedPitchDeg;

    @Column(name = "attitude_indicator_indicated_roll_deg")
    private Double attitudeIndicatorIndicatedRollDeg;

    @Column(name = "attitude_indicator_internal_pitch_deg")
    private Double attitudeIndicatorInternalPitchDeg;

    @Column(name = "attitude_indicator_internal_roll_deg")
    private Double attitudeIndicatorInternalRollDeg;

    @Column(name = "encoder_indicated_altitude_ft")
    private Double encoderIndicatedAltitudeFt;

    @Column(name = "encoder_pressure_alt_ft")
    private Double encoderPressureAltFt;

    @Column(name = "gps_indicated_altitude_ft")
    private Double gpsIndicatedAltitudeFt;

    @Column(name = "gps_indicated_ground_speed_kt")
    private Double gpsIndicatedGroundSpeedKt;

    @Column(name = "gps_indicated_vertical_speed")
    private Double gpsIndicatedVerticalSpeed;

    @Column(name = "indicated_heading_deg")
    private Double indicatedHeadingDeg;

    @Column(name = "magnetic_compass_indicated_heading_deg")
    private Double magneticCompassIndicatedHeadingDeg;

    @Column(name = "slip_skid_ball_indicated_slip_skid")
    private Double slipSkidBallIndicatedSlipSkid;

    @Column(name = "turn_indicator_indicated_turn_rate")
    private Double turnIndicatorIndicatedTurnRate;

    @Column(name = "vertical_speed_indicator_indicated_speed_fpm")
    private Double verticalSpeedIndicatorIndicatedSpeedFpm;

    @Column(name = "engine_rpm")
    private Double engineRpm;
    public Flightsdatum(String[] values,long timestamp,int Flightid) {
        this.timestamp=timestamp;
        this.flightid=Flightid;
        this.aileron=Double.parseDouble(values[0]);
        this.elevator=Double.parseDouble(values[1]);
        this.rudder=Double.parseDouble(values[2]);
        this.flaps=Double.parseDouble(values[3]);
        this.slats=Double.parseDouble(values[4]);
        this.speedbrake=Double.parseDouble(values[5]);
        this.throttle0=Double.parseDouble(values[6]);
        this.throttle1=Double.parseDouble(values[7]);
        this.enginePump0=Double.parseDouble(values[8]);
        this.enginePump1=Double.parseDouble(values[9]);
        this.electricPump0=Double.parseDouble(values[10]);
        this.electricPump1=Double.parseDouble(values[11]);
        this.externalPower=Double.parseDouble(values[12]);
        this.apuGenerator=Double.parseDouble(values[13]);
        this.latitudeDeg=Double.parseDouble(values[14]);
        this.longitudeDeg=Double.parseDouble(values[15]);
        this.altitudeFt=Double.parseDouble(values[16]);
        this.rollDeg=Double.parseDouble(values[17]);
        this.pitchDeg=Double.parseDouble(values[18]);
        this.headingDeg=Double.parseDouble(values[19]);
        this.sideSlipDeg=Double.parseDouble(values[20]);
        this.airspeedKt=Double.parseDouble(values[21]);
        this.glideslope=Double.parseDouble(values[22]);
        this.verticalSpeedFps=Double.parseDouble(values[23]);
        this.airspeedIndicatorIndicatedSpeedKt=Double.parseDouble(values[24]);
        this.altimeterIndicatedAltitudeFt=Double.parseDouble(values[25]);
        this.altimeterPressureAltFt=Double.parseDouble(values[26]);
        this.attitudeIndicatorIndicatedPitchDeg=Double.parseDouble(values[27]);
        this.attitudeIndicatorIndicatedRollDeg=Double.parseDouble(values[28]);
        this.attitudeIndicatorInternalPitchDeg=Double.parseDouble(values[29]);
        this.attitudeIndicatorInternalRollDeg=Double.parseDouble(values[30]);
        this.encoderIndicatedAltitudeFt=Double.parseDouble(values[31]);
        this.encoderPressureAltFt=Double.parseDouble(values[32]);
        this.gpsIndicatedAltitudeFt=Double.parseDouble(values[33]);
        this.gpsIndicatedGroundSpeedKt=Double.parseDouble(values[34]);
        this.gpsIndicatedVerticalSpeed=Double.parseDouble(values[35]);
        this.indicatedHeadingDeg=Double.parseDouble(values[36]);
        this.magneticCompassIndicatedHeadingDeg=Double.parseDouble(values[37]);
        this.slipSkidBallIndicatedSlipSkid=Double.parseDouble(values[38]);
        this.turnIndicatorIndicatedTurnRate=Double.parseDouble(values[39]);
        this.verticalSpeedIndicatorIndicatedSpeedFpm=Double.parseDouble(values[40]);
        this.engineRpm=Double.parseDouble(values[41]);

    }

    public Flightsdatum() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFlightid() {
        return flightid;
    }

    public void setFlightid(int flightid) {
        this.flightid = flightid;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Double getAileron() {
        return aileron;
    }

    public void setAileron(Double aileron) {
        this.aileron = aileron;
    }

    public Double getElevator() {
        return elevator;
    }

    public void setElevator(Double elevator) {
        this.elevator = elevator;
    }

    public Double getRudder() {
        return rudder;
    }

    public void setRudder(Double rudder) {
        this.rudder = rudder;
    }

    public Double getFlaps() {
        return flaps;
    }

    public void setFlaps(Double flaps) {
        this.flaps = flaps;
    }

    public Double getSlats() {
        return slats;
    }

    public void setSlats(Double slats) {
        this.slats = slats;
    }

    public Double getSpeedbrake() {
        return speedbrake;
    }

    public void setSpeedbrake(Double speedbrake) {
        this.speedbrake = speedbrake;
    }

    public Double getThrottle0() {
        return throttle0;
    }

    public void setThrottle0(Double throttle0) {
        this.throttle0 = throttle0;
    }

    public Double getThrottle1() {
        return throttle1;
    }

    public void setThrottle1(Double throttle1) {
        this.throttle1 = throttle1;
    }

    public Double getEnginePump0() {
        return enginePump0;
    }

    public void setEnginePump0(Double enginePump0) {
        this.enginePump0 = enginePump0;
    }

    public Double getEnginePump1() {
        return enginePump1;
    }

    public void setEnginePump1(Double enginePump1) {
        this.enginePump1 = enginePump1;
    }

    public Double getElectricPump0() {
        return electricPump0;
    }

    public void setElectricPump0(Double electricPump0) {
        this.electricPump0 = electricPump0;
    }

    public Double getElectricPump1() {
        return electricPump1;
    }

    public void setElectricPump1(Double electricPump1) {
        this.electricPump1 = electricPump1;
    }

    public Double getExternalPower() {
        return externalPower;
    }

    public void setExternalPower(Double externalPower) {
        this.externalPower = externalPower;
    }

    public Double getApuGenerator() {
        return apuGenerator;
    }

    public void setApuGenerator(Double apuGenerator) {
        this.apuGenerator = apuGenerator;
    }

    public Double getLatitudeDeg() {
        return latitudeDeg;
    }

    public void setLatitudeDeg(Double latitudeDeg) {
        this.latitudeDeg = latitudeDeg;
    }

    public Double getLongitudeDeg() {
        return longitudeDeg;
    }

    public void setLongitudeDeg(Double longitudeDeg) {
        this.longitudeDeg = longitudeDeg;
    }

    public Double getAltitudeFt() {
        return altitudeFt;
    }

    public void setAltitudeFt(Double altitudeFt) {
        this.altitudeFt = altitudeFt;
    }

    public Double getRollDeg() {
        return rollDeg;
    }

    public void setRollDeg(Double rollDeg) {
        this.rollDeg = rollDeg;
    }

    public Double getPitchDeg() {
        return pitchDeg;
    }

    public void setPitchDeg(Double pitchDeg) {
        this.pitchDeg = pitchDeg;
    }

    public Double getHeadingDeg() {
        return headingDeg;
    }

    public void setHeadingDeg(Double headingDeg) {
        this.headingDeg = headingDeg;
    }

    public Double getSideSlipDeg() {
        return sideSlipDeg;
    }

    public void setSideSlipDeg(Double sideSlipDeg) {
        this.sideSlipDeg = sideSlipDeg;
    }

    public Double getAirspeedKt() {
        return airspeedKt;
    }

    public void setAirspeedKt(Double airspeedKt) {
        this.airspeedKt = airspeedKt;
    }

    public Double getGlideslope() {
        return glideslope;
    }

    public void setGlideslope(Double glideslope) {
        this.glideslope = glideslope;
    }

    public Double getVerticalSpeedFps() {
        return verticalSpeedFps;
    }

    public void setVerticalSpeedFps(Double verticalSpeedFps) {
        this.verticalSpeedFps = verticalSpeedFps;
    }

    public Double getAirspeedIndicatorIndicatedSpeedKt() {
        return airspeedIndicatorIndicatedSpeedKt;
    }

    public void setAirspeedIndicatorIndicatedSpeedKt(Double airspeedIndicatorIndicatedSpeedKt) {
        this.airspeedIndicatorIndicatedSpeedKt = airspeedIndicatorIndicatedSpeedKt;
    }

    public Double getAltimeterIndicatedAltitudeFt() {
        return altimeterIndicatedAltitudeFt;
    }

    public void setAltimeterIndicatedAltitudeFt(Double altimeterIndicatedAltitudeFt) {
        this.altimeterIndicatedAltitudeFt = altimeterIndicatedAltitudeFt;
    }

    public Double getAltimeterPressureAltFt() {
        return altimeterPressureAltFt;
    }

    public void setAltimeterPressureAltFt(Double altimeterPressureAltFt) {
        this.altimeterPressureAltFt = altimeterPressureAltFt;
    }

    public Double getAttitudeIndicatorIndicatedPitchDeg() {
        return attitudeIndicatorIndicatedPitchDeg;
    }

    public void setAttitudeIndicatorIndicatedPitchDeg(Double attitudeIndicatorIndicatedPitchDeg) {
        this.attitudeIndicatorIndicatedPitchDeg = attitudeIndicatorIndicatedPitchDeg;
    }

    public Double getAttitudeIndicatorIndicatedRollDeg() {
        return attitudeIndicatorIndicatedRollDeg;
    }

    public void setAttitudeIndicatorIndicatedRollDeg(Double attitudeIndicatorIndicatedRollDeg) {
        this.attitudeIndicatorIndicatedRollDeg = attitudeIndicatorIndicatedRollDeg;
    }

    public Double getAttitudeIndicatorInternalPitchDeg() {
        return attitudeIndicatorInternalPitchDeg;
    }

    public void setAttitudeIndicatorInternalPitchDeg(Double attitudeIndicatorInternalPitchDeg) {
        this.attitudeIndicatorInternalPitchDeg = attitudeIndicatorInternalPitchDeg;
    }

    public Double getAttitudeIndicatorInternalRollDeg() {
        return attitudeIndicatorInternalRollDeg;
    }

    public void setAttitudeIndicatorInternalRollDeg(Double attitudeIndicatorInternalRollDeg) {
        this.attitudeIndicatorInternalRollDeg = attitudeIndicatorInternalRollDeg;
    }

    public Double getEncoderIndicatedAltitudeFt() {
        return encoderIndicatedAltitudeFt;
    }

    public void setEncoderIndicatedAltitudeFt(Double encoderIndicatedAltitudeFt) {
        this.encoderIndicatedAltitudeFt = encoderIndicatedAltitudeFt;
    }

    public Double getEncoderPressureAltFt() {
        return encoderPressureAltFt;
    }

    public void setEncoderPressureAltFt(Double encoderPressureAltFt) {
        this.encoderPressureAltFt = encoderPressureAltFt;
    }

    public Double getGpsIndicatedAltitudeFt() {
        return gpsIndicatedAltitudeFt;
    }

    public void setGpsIndicatedAltitudeFt(Double gpsIndicatedAltitudeFt) {
        this.gpsIndicatedAltitudeFt = gpsIndicatedAltitudeFt;
    }

    public Double getGpsIndicatedGroundSpeedKt() {
        return gpsIndicatedGroundSpeedKt;
    }

    public void setGpsIndicatedGroundSpeedKt(Double gpsIndicatedGroundSpeedKt) {
        this.gpsIndicatedGroundSpeedKt = gpsIndicatedGroundSpeedKt;
    }

    public Double getGpsIndicatedVerticalSpeed() {
        return gpsIndicatedVerticalSpeed;
    }

    public void setGpsIndicatedVerticalSpeed(Double gpsIndicatedVerticalSpeed) {
        this.gpsIndicatedVerticalSpeed = gpsIndicatedVerticalSpeed;
    }

    public Double getIndicatedHeadingDeg() {
        return indicatedHeadingDeg;
    }

    public void setIndicatedHeadingDeg(Double indicatedHeadingDeg) {
        this.indicatedHeadingDeg = indicatedHeadingDeg;
    }

    public Double getMagneticCompassIndicatedHeadingDeg() {
        return magneticCompassIndicatedHeadingDeg;
    }

    public void setMagneticCompassIndicatedHeadingDeg(Double magneticCompassIndicatedHeadingDeg) {
        this.magneticCompassIndicatedHeadingDeg = magneticCompassIndicatedHeadingDeg;
    }

    public Double getSlipSkidBallIndicatedSlipSkid() {
        return slipSkidBallIndicatedSlipSkid;
    }

    public void setSlipSkidBallIndicatedSlipSkid(Double slipSkidBallIndicatedSlipSkid) {
        this.slipSkidBallIndicatedSlipSkid = slipSkidBallIndicatedSlipSkid;
    }

    public Double getTurnIndicatorIndicatedTurnRate() {
        return turnIndicatorIndicatedTurnRate;
    }

    public void setTurnIndicatorIndicatedTurnRate(Double turnIndicatorIndicatedTurnRate) {
        this.turnIndicatorIndicatedTurnRate = turnIndicatorIndicatedTurnRate;
    }

    public Double getVerticalSpeedIndicatorIndicatedSpeedFpm() {
        return verticalSpeedIndicatorIndicatedSpeedFpm;
    }

    public void setVerticalSpeedIndicatorIndicatedSpeedFpm(Double verticalSpeedIndicatorIndicatedSpeedFpm) {
        this.verticalSpeedIndicatorIndicatedSpeedFpm = verticalSpeedIndicatorIndicatedSpeedFpm;
    }

    public Double getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(Double engineRpm) {
        this.engineRpm = engineRpm;
    }

    @Override
    public String toString() {
        return
                id +
                "," + flightid +
                "," + timestamp +
                "," + aileron +
                "," + elevator +
                "," + rudder +
                "," + flaps +
                "," + slats +
                "," + speedbrake +
                "," + throttle0 +
                "," + throttle1 +
                "," + enginePump0 +
                "," + enginePump1 +
                "," + electricPump0 +
                "," + electricPump1 +
                "," + externalPower +
                "," + apuGenerator +
                "," + latitudeDeg +
                "," + longitudeDeg +
                "," + altitudeFt +
                "," + rollDeg +
                "," + pitchDeg +
                "," + headingDeg +
                "," + sideSlipDeg +
                "," + airspeedKt +
                "," + glideslope +
                "," + verticalSpeedFps +
                "," + airspeedIndicatorIndicatedSpeedKt +
                "," + altimeterIndicatedAltitudeFt +
                "," + altimeterPressureAltFt +
                "," + attitudeIndicatorIndicatedPitchDeg +
                "," + attitudeIndicatorIndicatedRollDeg +
                "," + attitudeIndicatorInternalPitchDeg +
                "," + attitudeIndicatorInternalRollDeg +
                "," + encoderIndicatedAltitudeFt +
                "," + encoderPressureAltFt +
                "," + gpsIndicatedAltitudeFt +
                "," + gpsIndicatedGroundSpeedKt +
                "," + gpsIndicatedVerticalSpeed +
                "," + indicatedHeadingDeg +
                "," + magneticCompassIndicatedHeadingDeg +
                "," + slipSkidBallIndicatedSlipSkid +
                "," + turnIndicatorIndicatedTurnRate +
                "," + verticalSpeedIndicatorIndicatedSpeedFpm +
                "," + engineRpm;

    }
}