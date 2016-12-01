
package com.example.sebas.flickr.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Photo implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("secret")
    @Expose
    private String secret;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("farm")
    @Expose
    private Integer farm;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("ispublic")
    @Expose
    private Integer ispublic;
    @SerializedName("isfriend")
    @Expose
    private Integer isfriend;
    @SerializedName("isfamily")
    @Expose
    private Integer isfamily;
    @SerializedName("license")
    @Expose
    private Integer license;
    @SerializedName("description")
    @Expose
    private Description description;
    @SerializedName("dateupload")
    @Expose
    private String dateupload;
    @SerializedName("lastupdate")
    @Expose
    private String lastupdate;
    @SerializedName("datetaken")
    @Expose
    private String datetaken;
    @SerializedName("datetakengranularity")
    @Expose
    private Integer datetakengranularity;
    @SerializedName("datetakenunknown")
    @Expose
    private Integer datetakenunknown;
    @SerializedName("ownername")
    @Expose
    private String ownername;
    @SerializedName("iconserver")
    @Expose
    private Integer iconserver;
    @SerializedName("iconfarm")
    @Expose
    private Integer iconfarm;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("machine_tags")
    @Expose
    private String machineTags;
    @SerializedName("originalsecret")
    @Expose
    private String originalsecret;
    @SerializedName("originalformat")
    @Expose
    private String originalformat;
    @SerializedName("latitude")
    @Expose
    private Integer latitude;
    @SerializedName("longitude")
    @Expose
    private Integer longitude;
    @SerializedName("accuracy")
    @Expose
    private Integer accuracy;
    @SerializedName("context")
    @Expose
    private Integer context;
    @SerializedName("media")
    @Expose
    private String media;
    @SerializedName("media_status")
    @Expose
    private String mediaStatus;
    @SerializedName("url_sq")
    @Expose
    private String urlSq;
    @SerializedName("height_sq")
    @Expose
    private Integer heightSq;
    @SerializedName("width_sq")
    @Expose
    private Integer widthSq;
    @SerializedName("url_t")
    @Expose
    private String urlT;
    @SerializedName("height_t")
    @Expose
    private Integer heightT;
    @SerializedName("width_t")
    @Expose
    private Integer widthT;
    @SerializedName("url_s")
    @Expose
    private String urlS;
    @SerializedName("height_s")
    @Expose
    private String heightS;
    @SerializedName("width_s")
    @Expose
    private String widthS;
    @SerializedName("url_q")
    @Expose
    private String urlQ;
    @SerializedName("height_q")
    @Expose
    private String heightQ;
    @SerializedName("width_q")
    @Expose
    private String widthQ;
    @SerializedName("url_m")
    @Expose
    private String urlM;
    @SerializedName("height_m")
    @Expose
    private String heightM;
    @SerializedName("width_m")
    @Expose
    private String widthM;
    @SerializedName("url_n")
    @Expose
    private String urlN;
    @SerializedName("height_n")
    @Expose
    private String heightN;
    @SerializedName("width_n")
    @Expose
    private String widthN;
    @SerializedName("url_z")
    @Expose
    private String urlZ;
    @SerializedName("height_z")
    @Expose
    private String heightZ;
    @SerializedName("width_z")
    @Expose
    private String widthZ;
    @SerializedName("url_l")
    @Expose
    private String urlL;
    @SerializedName("height_l")
    @Expose
    private String heightL;
    @SerializedName("width_l")
    @Expose
    private String widthL;
    @SerializedName("url_o")
    @Expose
    private String urlO;
    @SerializedName("height_o")
    @Expose
    private String heightO;
    @SerializedName("width_o")
    @Expose
    private String widthO;
    @SerializedName("pathalias")
    @Expose
    private String pathalias;
    @SerializedName("url_c")
    @Expose
    private String urlC;
    @SerializedName("height_c")
    @Expose
    private String heightC;
    @SerializedName("width_c")
    @Expose
    private String widthC;
    @SerializedName("place_id")
    @Expose
    private String placeId;
    @SerializedName("woeid")
    @Expose
    private String woeid;
    @SerializedName("geo_is_family")
    @Expose
    private Integer geoIsFamily;
    @SerializedName("geo_is_friend")
    @Expose
    private Integer geoIsFriend;
    @SerializedName("geo_is_contact")
    @Expose
    private Integer geoIsContact;
    @SerializedName("geo_is_public")
    @Expose
    private Integer geoIsPublic;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 
     * @param owner
     *     The owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * 
     * @return
     *     The secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * 
     * @param secret
     *     The secret
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * 
     * @return
     *     The server
     */
    public String getServer() {
        return server;
    }

    /**
     * 
     * @param server
     *     The server
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * 
     * @return
     *     The farm
     */
    public Integer getFarm() {
        return farm;
    }

    /**
     * 
     * @param farm
     *     The farm
     */
    public void setFarm(Integer farm) {
        this.farm = farm;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The ispublic
     */
    public Integer getIspublic() {
        return ispublic;
    }

    /**
     * 
     * @param ispublic
     *     The ispublic
     */
    public void setIspublic(Integer ispublic) {
        this.ispublic = ispublic;
    }

    /**
     * 
     * @return
     *     The isfriend
     */
    public Integer getIsfriend() {
        return isfriend;
    }

    /**
     * 
     * @param isfriend
     *     The isfriend
     */
    public void setIsfriend(Integer isfriend) {
        this.isfriend = isfriend;
    }

    /**
     * 
     * @return
     *     The isfamily
     */
    public Integer getIsfamily() {
        return isfamily;
    }

    /**
     * 
     * @param isfamily
     *     The isfamily
     */
    public void setIsfamily(Integer isfamily) {
        this.isfamily = isfamily;
    }

    /**
     * 
     * @return
     *     The license
     */
    public Integer getLicense() {
        return license;
    }

    /**
     * 
     * @param license
     *     The license
     */
    public void setLicense(Integer license) {
        this.license = license;
    }

    /**
     * 
     * @return
     *     The description
     */
    public Description getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(Description description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The dateupload
     */
    public String getDateupload() {
        return dateupload;
    }

    /**
     * 
     * @param dateupload
     *     The dateupload
     */
    public void setDateupload(String dateupload) {
        this.dateupload = dateupload;
    }

    /**
     * 
     * @return
     *     The lastupdate
     */
    public String getLastupdate() {
        return lastupdate;
    }

    /**
     * 
     * @param lastupdate
     *     The lastupdate
     */
    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

    /**
     * 
     * @return
     *     The datetaken
     */
    public String getDatetaken() {
        return datetaken;
    }

    /**
     * 
     * @param datetaken
     *     The datetaken
     */
    public void setDatetaken(String datetaken) {
        this.datetaken = datetaken;
    }

    /**
     * 
     * @return
     *     The datetakengranularity
     */
    public Integer getDatetakengranularity() {
        return datetakengranularity;
    }

    /**
     * 
     * @param datetakengranularity
     *     The datetakengranularity
     */
    public void setDatetakengranularity(Integer datetakengranularity) {
        this.datetakengranularity = datetakengranularity;
    }

    /**
     * 
     * @return
     *     The datetakenunknown
     */
    public Integer getDatetakenunknown() {
        return datetakenunknown;
    }

    /**
     * 
     * @param datetakenunknown
     *     The datetakenunknown
     */
    public void setDatetakenunknown(Integer datetakenunknown) {
        this.datetakenunknown = datetakenunknown;
    }

    /**
     * 
     * @return
     *     The ownername
     */
    public String getOwnername() {
        return ownername;
    }

    /**
     * 
     * @param ownername
     *     The ownername
     */
    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    /**
     * 
     * @return
     *     The iconserver
     */
    public Integer getIconserver() {
        return iconserver;
    }

    /**
     * 
     * @param iconserver
     *     The iconserver
     */
    public void setIconserver(Integer iconserver) {
        this.iconserver = iconserver;
    }

    /**
     * 
     * @return
     *     The iconfarm
     */
    public Integer getIconfarm() {
        return iconfarm;
    }

    /**
     * 
     * @param iconfarm
     *     The iconfarm
     */
    public void setIconfarm(Integer iconfarm) {
        this.iconfarm = iconfarm;
    }

    /**
     * 
     * @return
     *     The views
     */
    public Integer getViews() {
        return views;
    }

    /**
     * 
     * @param views
     *     The views
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * 
     * @return
     *     The tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The machineTags
     */
    public String getMachineTags() {
        return machineTags;
    }

    /**
     * 
     * @param machineTags
     *     The machine_tags
     */
    public void setMachineTags(String machineTags) {
        this.machineTags = machineTags;
    }

    /**
     * 
     * @return
     *     The originalsecret
     */
    public String getOriginalsecret() {
        return originalsecret;
    }

    /**
     * 
     * @param originalsecret
     *     The originalsecret
     */
    public void setOriginalsecret(String originalsecret) {
        this.originalsecret = originalsecret;
    }

    /**
     * 
     * @return
     *     The originalformat
     */
    public String getOriginalformat() {
        return originalformat;
    }

    /**
     * 
     * @param originalformat
     *     The originalformat
     */
    public void setOriginalformat(String originalformat) {
        this.originalformat = originalformat;
    }

    /**
     * 
     * @return
     *     The latitude
     */
    public Integer getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The latitude
     */
    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    public Integer getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The longitude
     */
    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    /**
     * 
     * @return
     *     The accuracy
     */
    public Integer getAccuracy() {
        return accuracy;
    }

    /**
     * 
     * @param accuracy
     *     The accuracy
     */
    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * 
     * @return
     *     The context
     */
    public Integer getContext() {
        return context;
    }

    /**
     * 
     * @param context
     *     The context
     */
    public void setContext(Integer context) {
        this.context = context;
    }

    /**
     * 
     * @return
     *     The media
     */
    public String getMedia() {
        return media;
    }

    /**
     * 
     * @param media
     *     The media
     */
    public void setMedia(String media) {
        this.media = media;
    }

    /**
     * 
     * @return
     *     The mediaStatus
     */
    public String getMediaStatus() {
        return mediaStatus;
    }

    /**
     * 
     * @param mediaStatus
     *     The media_status
     */
    public void setMediaStatus(String mediaStatus) {
        this.mediaStatus = mediaStatus;
    }

    /**
     * 
     * @return
     *     The urlSq
     */
    public String getUrlSq() {
        return urlSq;
    }

    /**
     * 
     * @param urlSq
     *     The url_sq
     */
    public void setUrlSq(String urlSq) {
        this.urlSq = urlSq;
    }

    /**
     * 
     * @return
     *     The heightSq
     */
    public Integer getHeightSq() {
        return heightSq;
    }

    /**
     * 
     * @param heightSq
     *     The height_sq
     */
    public void setHeightSq(Integer heightSq) {
        this.heightSq = heightSq;
    }

    /**
     * 
     * @return
     *     The widthSq
     */
    public Integer getWidthSq() {
        return widthSq;
    }

    /**
     * 
     * @param widthSq
     *     The width_sq
     */
    public void setWidthSq(Integer widthSq) {
        this.widthSq = widthSq;
    }

    /**
     * 
     * @return
     *     The urlT
     */
    public String getUrlT() {
        return urlT;
    }

    /**
     * 
     * @param urlT
     *     The url_t
     */
    public void setUrlT(String urlT) {
        this.urlT = urlT;
    }

    /**
     * 
     * @return
     *     The heightT
     */
    public Integer getHeightT() {
        return heightT;
    }

    /**
     * 
     * @param heightT
     *     The height_t
     */
    public void setHeightT(Integer heightT) {
        this.heightT = heightT;
    }

    /**
     * 
     * @return
     *     The widthT
     */
    public Integer getWidthT() {
        return widthT;
    }

    /**
     * 
     * @param widthT
     *     The width_t
     */
    public void setWidthT(Integer widthT) {
        this.widthT = widthT;
    }

    /**
     * 
     * @return
     *     The urlS
     */
    public String getUrlS() {
        return urlS;
    }

    /**
     * 
     * @param urlS
     *     The url_s
     */
    public void setUrlS(String urlS) {
        this.urlS = urlS;
    }

    /**
     * 
     * @return
     *     The heightS
     */
    public String getHeightS() {
        return heightS;
    }

    /**
     * 
     * @param heightS
     *     The height_s
     */
    public void setHeightS(String heightS) {
        this.heightS = heightS;
    }

    /**
     * 
     * @return
     *     The widthS
     */
    public String getWidthS() {
        return widthS;
    }

    /**
     * 
     * @param widthS
     *     The width_s
     */
    public void setWidthS(String widthS) {
        this.widthS = widthS;
    }

    /**
     * 
     * @return
     *     The urlQ
     */
    public String getUrlQ() {
        return urlQ;
    }

    /**
     * 
     * @param urlQ
     *     The url_q
     */
    public void setUrlQ(String urlQ) {
        this.urlQ = urlQ;
    }

    /**
     * 
     * @return
     *     The heightQ
     */
    public String getHeightQ() {
        return heightQ;
    }

    /**
     * 
     * @param heightQ
     *     The height_q
     */
    public void setHeightQ(String heightQ) {
        this.heightQ = heightQ;
    }

    /**
     * 
     * @return
     *     The widthQ
     */
    public String getWidthQ() {
        return widthQ;
    }

    /**
     * 
     * @param widthQ
     *     The width_q
     */
    public void setWidthQ(String widthQ) {
        this.widthQ = widthQ;
    }

    /**
     * 
     * @return
     *     The urlM
     */
    public String getUrlM() {
        return urlM;
    }

    /**
     * 
     * @param urlM
     *     The url_m
     */
    public void setUrlM(String urlM) {
        this.urlM = urlM;
    }

    /**
     * 
     * @return
     *     The heightM
     */
    public String getHeightM() {
        return heightM;
    }

    /**
     * 
     * @param heightM
     *     The height_m
     */
    public void setHeightM(String heightM) {
        this.heightM = heightM;
    }

    /**
     * 
     * @return
     *     The widthM
     */
    public String getWidthM() {
        return widthM;
    }

    /**
     * 
     * @param widthM
     *     The width_m
     */
    public void setWidthM(String widthM) {
        this.widthM = widthM;
    }

    /**
     * 
     * @return
     *     The urlN
     */
    public String getUrlN() {
        return urlN;
    }

    /**
     * 
     * @param urlN
     *     The url_n
     */
    public void setUrlN(String urlN) {
        this.urlN = urlN;
    }

    /**
     * 
     * @return
     *     The heightN
     */
    public String getHeightN() {
        return heightN;
    }

    /**
     * 
     * @param heightN
     *     The height_n
     */
    public void setHeightN(String heightN) {
        this.heightN = heightN;
    }

    /**
     * 
     * @return
     *     The widthN
     */
    public String getWidthN() {
        return widthN;
    }

    /**
     * 
     * @param widthN
     *     The width_n
     */
    public void setWidthN(String widthN) {
        this.widthN = widthN;
    }

    /**
     * 
     * @return
     *     The urlZ
     */
    public String getUrlZ() {
        return urlZ;
    }

    /**
     * 
     * @param urlZ
     *     The url_z
     */
    public void setUrlZ(String urlZ) {
        this.urlZ = urlZ;
    }

    /**
     * 
     * @return
     *     The heightZ
     */
    public String getHeightZ() {
        return heightZ;
    }

    /**
     * 
     * @param heightZ
     *     The height_z
     */
    public void setHeightZ(String heightZ) {
        this.heightZ = heightZ;
    }

    /**
     * 
     * @return
     *     The widthZ
     */
    public String getWidthZ() {
        return widthZ;
    }

    /**
     * 
     * @param widthZ
     *     The width_z
     */
    public void setWidthZ(String widthZ) {
        this.widthZ = widthZ;
    }

    /**
     * 
     * @return
     *     The urlL
     */
    public String getUrlL() {
        return urlL;
    }

    /**
     * 
     * @param urlL
     *     The url_l
     */
    public void setUrlL(String urlL) {
        this.urlL = urlL;
    }

    /**
     * 
     * @return
     *     The heightL
     */
    public String getHeightL() {
        return heightL;
    }

    /**
     * 
     * @param heightL
     *     The height_l
     */
    public void setHeightL(String heightL) {
        this.heightL = heightL;
    }

    /**
     * 
     * @return
     *     The widthL
     */
    public String getWidthL() {
        return widthL;
    }

    /**
     * 
     * @param widthL
     *     The width_l
     */
    public void setWidthL(String widthL) {
        this.widthL = widthL;
    }

    /**
     * 
     * @return
     *     The urlO
     */
    public String getUrlO() {
        return urlO;
    }

    /**
     * 
     * @param urlO
     *     The url_o
     */
    public void setUrlO(String urlO) {
        this.urlO = urlO;
    }

    /**
     * 
     * @return
     *     The heightO
     */
    public String getHeightO() {
        return heightO;
    }

    /**
     * 
     * @param heightO
     *     The height_o
     */
    public void setHeightO(String heightO) {
        this.heightO = heightO;
    }

    /**
     * 
     * @return
     *     The widthO
     */
    public String getWidthO() {
        return widthO;
    }

    /**
     * 
     * @param widthO
     *     The width_o
     */
    public void setWidthO(String widthO) {
        this.widthO = widthO;
    }

    /**
     * 
     * @return
     *     The pathalias
     */
    public String getPathalias() {
        return pathalias;
    }

    /**
     * 
     * @param pathalias
     *     The pathalias
     */
    public void setPathalias(String pathalias) {
        this.pathalias = pathalias;
    }

    /**
     * 
     * @return
     *     The urlC
     */
    public String getUrlC() {
        return urlC;
    }

    /**
     * 
     * @param urlC
     *     The url_c
     */
    public void setUrlC(String urlC) {
        this.urlC = urlC;
    }

    /**
     * 
     * @return
     *     The heightC
     */
    public String getHeightC() {
        return heightC;
    }

    /**
     * 
     * @param heightC
     *     The height_c
     */
    public void setHeightC(String heightC) {
        this.heightC = heightC;
    }

    /**
     * 
     * @return
     *     The widthC
     */
    public String getWidthC() {
        return widthC;
    }

    /**
     * 
     * @param widthC
     *     The width_c
     */
    public void setWidthC(String widthC) {
        this.widthC = widthC;
    }

    /**
     * 
     * @return
     *     The placeId
     */
    public String getPlaceId() {
        return placeId;
    }

    /**
     * 
     * @param placeId
     *     The place_id
     */
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    /**
     * 
     * @return
     *     The woeid
     */
    public String getWoeid() {
        return woeid;
    }

    /**
     * 
     * @param woeid
     *     The woeid
     */
    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }

    /**
     * 
     * @return
     *     The geoIsFamily
     */
    public Integer getGeoIsFamily() {
        return geoIsFamily;
    }

    /**
     * 
     * @param geoIsFamily
     *     The geo_is_family
     */
    public void setGeoIsFamily(Integer geoIsFamily) {
        this.geoIsFamily = geoIsFamily;
    }

    /**
     * 
     * @return
     *     The geoIsFriend
     */
    public Integer getGeoIsFriend() {
        return geoIsFriend;
    }

    /**
     * 
     * @param geoIsFriend
     *     The geo_is_friend
     */
    public void setGeoIsFriend(Integer geoIsFriend) {
        this.geoIsFriend = geoIsFriend;
    }

    /**
     * 
     * @return
     *     The geoIsContact
     */
    public Integer getGeoIsContact() {
        return geoIsContact;
    }

    /**
     * 
     * @param geoIsContact
     *     The geo_is_contact
     */
    public void setGeoIsContact(Integer geoIsContact) {
        this.geoIsContact = geoIsContact;
    }

    /**
     * 
     * @return
     *     The geoIsPublic
     */
    public Integer getGeoIsPublic() {
        return geoIsPublic;
    }

    /**
     * 
     * @param geoIsPublic
     *     The geo_is_public
     */
    public void setGeoIsPublic(Integer geoIsPublic) {
        this.geoIsPublic = geoIsPublic;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.owner);
        dest.writeString(this.secret);
        dest.writeString(this.server);
        dest.writeValue(this.farm);
        dest.writeString(this.title);
        dest.writeValue(this.ispublic);
        dest.writeValue(this.isfriend);
        dest.writeValue(this.isfamily);
        dest.writeValue(this.license);
        dest.writeParcelable(this.description, flags);
        dest.writeString(this.dateupload);
        dest.writeString(this.lastupdate);
        dest.writeString(this.datetaken);
        dest.writeValue(this.datetakengranularity);
        dest.writeValue(this.datetakenunknown);
        dest.writeString(this.ownername);
        dest.writeValue(this.iconserver);
        dest.writeValue(this.iconfarm);
        dest.writeValue(this.views);
        dest.writeString(this.tags);
        dest.writeString(this.machineTags);
        dest.writeString(this.originalsecret);
        dest.writeString(this.originalformat);
        dest.writeValue(this.latitude);
        dest.writeValue(this.longitude);
        dest.writeValue(this.accuracy);
        dest.writeValue(this.context);
        dest.writeString(this.media);
        dest.writeString(this.mediaStatus);
        dest.writeString(this.urlSq);
        dest.writeValue(this.heightSq);
        dest.writeValue(this.widthSq);
        dest.writeString(this.urlT);
        dest.writeValue(this.heightT);
        dest.writeValue(this.widthT);
        dest.writeString(this.urlS);
        dest.writeString(this.heightS);
        dest.writeString(this.widthS);
        dest.writeString(this.urlQ);
        dest.writeString(this.heightQ);
        dest.writeString(this.widthQ);
        dest.writeString(this.urlM);
        dest.writeString(this.heightM);
        dest.writeString(this.widthM);
        dest.writeString(this.urlN);
        dest.writeString(this.heightN);
        dest.writeString(this.widthN);
        dest.writeString(this.urlZ);
        dest.writeString(this.heightZ);
        dest.writeString(this.widthZ);
        dest.writeString(this.urlL);
        dest.writeString(this.heightL);
        dest.writeString(this.widthL);
        dest.writeString(this.urlO);
        dest.writeString(this.heightO);
        dest.writeString(this.widthO);
        dest.writeString(this.pathalias);
        dest.writeString(this.urlC);
        dest.writeString(this.heightC);
        dest.writeString(this.widthC);
        dest.writeString(this.placeId);
        dest.writeString(this.woeid);
        dest.writeValue(this.geoIsFamily);
        dest.writeValue(this.geoIsFriend);
        dest.writeValue(this.geoIsContact);
        dest.writeValue(this.geoIsPublic);
    }

    public Photo() {
    }

    protected Photo(Parcel in) {
        this.id = in.readString();
        this.owner = in.readString();
        this.secret = in.readString();
        this.server = in.readString();
        this.farm = (Integer) in.readValue(Integer.class.getClassLoader());
        this.title = in.readString();
        this.ispublic = (Integer) in.readValue(Integer.class.getClassLoader());
        this.isfriend = (Integer) in.readValue(Integer.class.getClassLoader());
        this.isfamily = (Integer) in.readValue(Integer.class.getClassLoader());
        this.license = (Integer) in.readValue(Integer.class.getClassLoader());
        this.description = in.readParcelable(Description.class.getClassLoader());
        this.dateupload = in.readString();
        this.lastupdate = in.readString();
        this.datetaken = in.readString();
        this.datetakengranularity = (Integer) in.readValue(Integer.class.getClassLoader());
        this.datetakenunknown = (Integer) in.readValue(Integer.class.getClassLoader());
        this.ownername = in.readString();
        this.iconserver = (Integer) in.readValue(Integer.class.getClassLoader());
        this.iconfarm = (Integer) in.readValue(Integer.class.getClassLoader());
        this.views = (Integer) in.readValue(Integer.class.getClassLoader());
        this.tags = in.readString();
        this.machineTags = in.readString();
        this.originalsecret = in.readString();
        this.originalformat = in.readString();
        this.latitude = (Integer) in.readValue(Integer.class.getClassLoader());
        this.longitude = (Integer) in.readValue(Integer.class.getClassLoader());
        this.accuracy = (Integer) in.readValue(Integer.class.getClassLoader());
        this.context = (Integer) in.readValue(Integer.class.getClassLoader());
        this.media = in.readString();
        this.mediaStatus = in.readString();
        this.urlSq = in.readString();
        this.heightSq = (Integer) in.readValue(Integer.class.getClassLoader());
        this.widthSq = (Integer) in.readValue(Integer.class.getClassLoader());
        this.urlT = in.readString();
        this.heightT = (Integer) in.readValue(Integer.class.getClassLoader());
        this.widthT = (Integer) in.readValue(Integer.class.getClassLoader());
        this.urlS = in.readString();
        this.heightS = in.readString();
        this.widthS = in.readString();
        this.urlQ = in.readString();
        this.heightQ = in.readString();
        this.widthQ = in.readString();
        this.urlM = in.readString();
        this.heightM = in.readString();
        this.widthM = in.readString();
        this.urlN = in.readString();
        this.heightN = in.readString();
        this.widthN = in.readString();
        this.urlZ = in.readString();
        this.heightZ = in.readString();
        this.widthZ = in.readString();
        this.urlL = in.readString();
        this.heightL = in.readString();
        this.widthL = in.readString();
        this.urlO = in.readString();
        this.heightO = in.readString();
        this.widthO = in.readString();
        this.pathalias = in.readString();
        this.urlC = in.readString();
        this.heightC = in.readString();
        this.widthC = in.readString();
        this.placeId = in.readString();
        this.woeid = in.readString();
        this.geoIsFamily = (Integer) in.readValue(Integer.class.getClassLoader());
        this.geoIsFriend = (Integer) in.readValue(Integer.class.getClassLoader());
        this.geoIsContact = (Integer) in.readValue(Integer.class.getClassLoader());
        this.geoIsPublic = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        public Photo createFromParcel(Parcel source) {
            return new Photo(source);
        }

        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };
}
