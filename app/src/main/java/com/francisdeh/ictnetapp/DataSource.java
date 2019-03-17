package com.francisdeh.ictnetapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FrancisDeh on 11/3/2017.
 */

public class DataSource {

    private static List<Video> myVideos = null;
    private static List<Image> myImages = null;
    private static List<Term> myTerms = null;

    public static List<Video> getVideos(){
        myVideos = new ArrayList<>();
        myVideos.add(new Video("Application Programming Interface", "application_programming_interface", "03 mins 24 secs"));
        myVideos.add(new Video("Cloud Firestore","cloud_firestore", "02 mins 22 secs"));
        myVideos.add(new Video("History of the Internet", "history_of_the_internet", "08 mins 09 secs"));
        myVideos.add(new Video("How to Create a Facebook Page", "how_to_create_a_facebook_page", "03 mins 12 secs"));
        myVideos.add(new Video("How to Create Gmail Account", "how_to_create_gmail_account", "01 mins 26 secs"));
        myVideos.add(new Video("How to Upload Videos to Youtube", "how_to_upload_videos_to_youtube", "02 mins 58 secs"));
        myVideos.add(new Video("How to use Google Search", "how_to_use_google_search","05 mins 59 secs"));
        myVideos.add(new Video("Internet of Things Architecture for Beginners", "internet_of_things_architecture_for_beginners", "04 mins 19 secs"));
        myVideos.add(new Video("Internet of Things, How it Works", "internet_of_things_how_it_works","03 mins 38 secs"));
        myVideos.add(new Video("Networking Devices", "networking_devices","05 mins 42 secs"));


        return myVideos;
    }
    
    public static List<Image> getImages(){
        myImages = new ArrayList<>();
        myImages.add(new Image("CAT5 Networking Cable", R.drawable.cat5_networking_cable));
        myImages.add(new Image("Connected Network Cables", R.drawable.connected_network_cables));
        myImages.add(new Image("Connected Network Devices", R.drawable.connected_networking_devices));
        myImages.add(new Image("Crossover Network Cables", R.drawable.crossover_network_cables));
        myImages.add(new Image("Ethernet Cable Ports", R.drawable.ethernet_cable_ports));
        myImages.add(new Image("Ethernet Network Cables", R.drawable.ethernet_network_cables));
        myImages.add(new Image("Huawei Modem", R.drawable.huawei_modem));
        myImages.add(new Image("Internet of Things", R.drawable.internet_of_things));
        myImages.add(new Image("Local Area Network", R.drawable.local_area_network));
        myImages.add(new Image("Networking Hubs", R.drawable.neworking_hubs));
        myImages.add(new Image("Print Server", R.drawable.print_server));
        myImages.add(new Image("Social Network Icons", R.drawable.social_network_icons));
        myImages.add(new Image("VGA Cable", R.drawable.vga_cable));
        myImages.add(new Image("VGA Cable", R.drawable.vga_cable_2));

        return myImages;
    }
    
    public static List<Term> getTerms(){
        myTerms = new ArrayList<>();
        myTerms.add(new Term("ACL", "Access Control List"));
        myTerms.add(new Term("ADSL", "Asymmetric Digital Subscriber Line"));
        myTerms.add(new Term("ARP", "Address Resolution Protocol"));
        myTerms.add(new Term("ARPA", "Advanced Research Agency"));
        myTerms.add(new Term("ARPANET", "Advanced Research Project Agency Network"));
        myTerms.add(new Term("AV", "Antivirus"));
        myTerms.add(new Term("bin", "Binary"));
        myTerms.add(new Term("bit", "binary digit"));
        myTerms.add(new Term("Blog", "Web Log"));
        myTerms.add(new Term("bps", "bits per second"));
        myTerms.add(new Term("BT", "Bluetooth"));
        myTerms.add(new Term("BW", "Band Width"));
        myTerms.add(new Term("BCC", "Blind Carbon Copy"));
        myTerms.add(new Term("CC", "Carbon Copy"));
        myTerms.add(new Term("CAPTCHA", "Completely Automated Public Turing Test to tell Computers and Humans Apart"));
        myTerms.add(new Term("CLI", "Command Line Interface"));
        myTerms.add(new Term("CTCP", "Client To-Client Protocol"));
        myTerms.add(new Term("CTI", "Computer Telephony Integration"));
        myTerms.add(new Term("DB", "Database"));
        myTerms.add(new Term("DL", "Download"));
        myTerms.add(new Term("DSL", "Digital Subscriber Line"));
        myTerms.add(new Term("E-mail", "Electronic mail"));
        myTerms.add(new Term("eID", "Electronic ID card"));
        myTerms.add(new Term("FAQ", "Frequently Asked Question"));
        myTerms.add(new Term("FTP", "File Transfer Protocol"));
        myTerms.add(new Term("FQDN", "Fully Qualified Domain Name"));
        myTerms.add(new Term("FYI", "For Your Information"));
        myTerms.add(new Term("Gb", "Gigabit"));
        myTerms.add(new Term("GB", "Gigabyte"));
        myTerms.add(new Term("GIF", "Graphics Interchange Format"));
        myTerms.add(new Term("GIGO", "Garbage In Garbage Out"));
        myTerms.add(new Term("GPRS", "General Packet Radio Service"));
        myTerms.add(new Term("GMS", "Global System for Mobile Communications"));
        myTerms.add(new Term("GUI", "Graphical User Interface"));
        myTerms.add(new Term("HD", "High Definition"));
        myTerms.add(new Term("HDMI", "High Definition Multimedia Interface"));
        myTerms.add(new Term("HF", "High Frequency"));
        myTerms.add(new Term("HTML", "Hypertext Markup Language"));
        myTerms.add(new Term("HTTP", "Hypertext Transfer Protocol"));
        myTerms.add(new Term("HTTPS", "Hypertext Transfer Protocol Secured"));
        myTerms.add(new Term("Hz", "Hertz"));
        myTerms.add(new Term("IBM", "International Business Machines"));
        myTerms.add(new Term("IC", "Integrated Circuit"));
        myTerms.add(new Term("ICS", "Internet Connection Sharing"));
        myTerms.add(new Term("ICT", "Information and Communication Technology"));
        myTerms.add(new Term("IE", "Internet Explorer"));
        myTerms.add(new Term("IEEE", "Institute of Electrical and Electronics Engineers"));
        myTerms.add(new Term("IM","Instant Messaging"));
        myTerms.add(new Term("IMAP", "Internet Messaging Access Protocol"));
        myTerms.add(new Term("I/O ", "Input/Output"));
        myTerms.add(new Term("IoT", "Internet of Things"));
        myTerms.add(new Term("IP", "Internet Protocol"));
        myTerms.add(new Term("IS", "Information System"));
        myTerms.add(new Term("ISP", "Internet Service Provider"));
        myTerms.add(new Term("IT", "Information Technology"));
        myTerms.add(new Term("Kb" , "Kilobit"));
        myTerms.add(new Term("KB", "Kilobyte"));
        myTerms.add(new Term("KVM", "Keyboard, Video, Mouse"));
        myTerms.add(new Term("KHz", "Kilohertz"));
        myTerms.add(new Term("LAN", "Local Area Network"));
        myTerms.add(new Term("LCD", "Liquid Crystal Display"));
        myTerms.add(new Term("MAN", "Metropolitan Area Network"));
        myTerms.add(new Term("Mb", "Megabit"));
        myTerms.add(new Term("MB", "Megabyte"));
        myTerms.add(new Term("ME", "Microsoft Edge"));
        myTerms.add(new Term("MHz", "Megahertz"));
        myTerms.add(new Term("MIT", "Massachusetts Institute of Technology"));
        myTerms.add(new Term("MS", "Microsoft"));
        myTerms.add(new Term("MSN", "Microsoft Network"));
        myTerms.add(new Term("MX", "Mail Exchange"));
        myTerms.add(new Term("NetBIOS", "Network Basic Input/Output System"));
        myTerms.add(new Term("P2P", "Peer-To-Peer"));
        myTerms.add(new Term("PAN", "Personal Area Network"));
        myTerms.add(new Term("PDA", "Personal Digital Assistant"));
        myTerms.add(new Term("PNG", "Portable Network Graphics"));
        myTerms.add(new Term("PnP", "Plug and Play"));
        myTerms.add(new Term("RD",  "Remote Desktop"));
        myTerms.add(new Term("RDC", "Remote Desktop Connection"));
        myTerms.add(new Term("RF", "Radio Frequency"));
        myTerms.add(new Term("RFID", "Radio Frequency Identification"));
        myTerms.add(new Term("SAN", "Storage Area Network"));
        myTerms.add(new Term("SDSL", "Symmetric Digital Subscriber Line"));
        myTerms.add(new Term("SMTP", "Simple Mail Transfer Protocol"));
        myTerms.add(new Term("SMS", "Short Message Service"));
        myTerms.add(new Term("SOHO", "Small Office/Home Office"));
        myTerms.add(new Term("TCP/IP", "Transmission Control Protocol/Internet Protocol"));
        myTerms.add(new Term("TB", "TeraByte"));
        myTerms.add(new Term("TTS", "Text to Speech"));
        myTerms.add(new Term("UAC", "User Account Control"));
        myTerms.add(new Term("UHF", "Ultra High Frequency"));
        myTerms.add(new Term("UL", "Upload"));
        myTerms.add(new Term("URI", "Uniform Resource Identifier"));
        myTerms.add(new Term("URL", "Uniform Resource Locator"));
        myTerms.add(new Term("USN", "Uniform Resource Name"));
        myTerms.add(new Term("USB", "Universal Serial Bus"));
        myTerms.add(new Term("VLAN", "Virtual Local Area Network"));
        myTerms.add(new Term("VoIP", "Voice over Internet Protocol"));
        myTerms.add(new Term("VPN", "Virtual Private Network"));
        myTerms.add(new Term("WWW", "World Wide Web"));
        myTerms.add(new Term("W3C", "World Wide Web Consortium"));
        myTerms.add(new Term("WIFI", "Wireless Fidelity"));
        myTerms.add(new Term("WAN", "Wide Area Network"));
        myTerms.add(new Term("WLAN", "Wireless Local Area Network"));
        myTerms.add(new Term("WPAN", "Wireless Personal Area Network"));
        myTerms.add(new Term("WUSB", "Wireless Universal Serial Bus"));
        myTerms.add(new Term("WYSIWYG", "What You See Is What You Get"));

        return myTerms;
    }
}
