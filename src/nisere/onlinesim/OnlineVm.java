package nisere.onlinesim;

import org.cloudbus.cloudsim.CloudletScheduler;
import org.cloudbus.cloudsim.Vm;

/**
 * This class adds to the Cloudsim Vm class a cost per instance and a connection to a datacenter.
 * 
 * @author Alina Chera
 *
 */
public class OnlineVm extends Vm {
	/** Last id assigned to an object of this class */
	protected static int lastId = 0;

	/**
	 * The id of the datacenter where this VM is allocated.
	 * A negative value means no allocation.
	 */
	private int datacenterId;
	
	/** The instance type */
	private VmType vmType;
	
	/** Uptime of this VM */
	private double uptime;
	
	/** Cost of using this VM */
	private double cost;

	/**
	 * Creates a new OnlineVm object.
	 * 
	 * @param userId
	 *            the id of this VM's owner
	 * @param mips
	 *            the mips of this VM
	 * @param numberOfPes
	 *            the number of CPUs of this VM
	 * @param ram
	 *            the amount of RAM (in MB)
	 * @param bw
	 *            the amount of bandwidth (in Mbps)
	 * @param size
	 *            the size the VM image size (the amount of storage it will use,
	 *            at least initially) (in MB)
	 * @param vmm
	 *            the virtual machine monitor that manages this VM
	 * @param cloudletScheduler
	 *            the cloudlet scheduler policy for cloudlets scheduling
	 */
	public OnlineVm(final int userId, final double mips,
			final int numberOfPes, final int ram, final long bw,
			final long size, final String vmm,
			final CloudletScheduler cloudletScheduler) {
		super(++lastId, userId, mips, numberOfPes, ram, bw, size, vmm,
				cloudletScheduler);

		setDatacenterId(-1);
		setUptime(0.0);
		setCost(0.0);
	}
	
	/**
	 * Creates a new OnlineVm object.
	 * 
	 * @param userId
	 *            the id of this VM's owner
	 * @param mips
	 *            the mips of this VM
	 * @param numberOfPes
	 *            the number of CPUs of this VM
	 * @param ram
	 *            the amount of RAM (in MB)
	 * @param bw
	 *            the amount of bandwidth (in Mbps)
	 * @param size
	 *            the size the VM image size (the amount of storage it will use,
	 *            at least initially) (in MB)
	 * @param vmm
	 *            the virtual machine monitor that manages this VM
	 * @param cloudletScheduler
	 *            the cloudlet scheduler policy for cloudlets scheduling
	 * @param datacenterId
	 *            the id of the datacenter assigned to the VM
	 */
	public OnlineVm(final int userId, final double mips,
			final int numberOfPes, final int ram, final long bw,
			final long size, final String vmm,
			final CloudletScheduler cloudletScheduler,
			int datacenterId) {
		this(userId, mips, numberOfPes, ram, bw, size, vmm,
				cloudletScheduler);

		setDatacenterId(datacenterId);
	}
	
	/**
	 * Gets the id of the datacenter to which this VM belongs.
	 * 
	 * @return the id of the datacenter to which this VM belongs
	 */
	public int getDatacenterId() {
		return datacenterId;
	}

	/**
	 * Sets the id of the datacenter to which this VM belongs.
	 * 
	 * @param id the id of the datacenter to which this VM belongs
	 */
	public void setDatacenterId(int id) {
		datacenterId = id;
	}

	public VmType getVmType() {
		return vmType;
	}

	public void setVmType(VmType vmType) {
		this.vmType = vmType;
	}

	public double getUptime() {
		return uptime;
	}

	public void setUptime(double time) {
		this.uptime = time;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
