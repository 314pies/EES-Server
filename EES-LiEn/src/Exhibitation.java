import java.util.Date;
import java.util.List;
//class set the exhibitation
public class Exhibitation {
	//exhibitation No.
	private int id;
	//exhibitation Name
	private String name;
	//mysql Date format yyyy-mm-dd
	private Date startDate;
	private Date endDate;
	//exhibitation's location
	private String exhibitationLocation;
	//exhibitation's information
	private String moreInformation;
	//who establish exhibitation
	private int hostID;
	//exhibitation have several boothes
	List<Booth> boothes;

	//have been set the exhibitation
	public Exhibitation(int _id, String _name, Date _sDate, 
			Date _eDate, String _exLocation, String _mInformation,
			int _hostNum, List<Booth> _boothes) {
		this.id = _id;
		this.name = _name;
		this.startDate = _sDate;
		this.endDate = _eDate;
		this.exhibitationLocation = _exLocation;
		this.moreInformation = _mInformation;
		this.hostID = _hostNum;
		this.boothes = _boothes;
	}
	
	public boolean updateExhibitation(int _id, String _name, Date _sDate, 
			Date _eDate, String _exLocation, String _mInformation,
			int _hostNum) {
		try {
			this.id = _id;
			this.name = _name;
			this.startDate = _sDate;
			this.endDate = _eDate;
			this.exhibitationLocation = _exLocation;
			this.moreInformation = _mInformation;
			this.hostID = _hostNum;
			return true;
		}catch(Exception epp) {
			return false;
		}
	}
	
	public boolean addBooth() {
		
	}
}
