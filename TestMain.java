import org.apache.commons.lang3.StringUtils;

public class TestMain {

	private static void splitPca(String address) {
		String addressFlag = address;
		String province = null;
		String city = null;
		String county = null;
		String street = null;
		if (address.indexOf("北京") > -1 || address.indexOf("天津") > -1 || address.indexOf("上海") > -1
				|| address.indexOf("重庆") > -1) {
			// 省名称
			if (address.indexOf("市") > -1) {
				province = addressFlag.substring(0, addressFlag.indexOf("市")) + "市";
				addressFlag = addressFlag.substring(addressFlag.indexOf("市") + 1);
			}
			// 市名称
			city = "市辖区";
			// 区名称
			if (addressFlag.indexOf(" ") > -1) {
				addressFlag = addressFlag.substring(addressFlag.indexOf(" ") + 1);
			}
			if (addressFlag.indexOf("区") > -1) {
				county = addressFlag.substring(0, addressFlag.indexOf("区")) + "区";
				addressFlag = addressFlag.substring(addressFlag.indexOf("区") + 1);
			} else if (addressFlag.indexOf("县") > -1) {
				county = addressFlag.substring(0, addressFlag.indexOf("县")) + "县";
				addressFlag = addressFlag.substring(addressFlag.indexOf("市") + 1);
			} else if (addressFlag.indexOf("镇") > -1) {
				county = addressFlag.substring(0, addressFlag.indexOf("镇")) + "镇";
				addressFlag = addressFlag.substring(addressFlag.indexOf("镇") + 1);
			}
		} else if (address.indexOf("香港") > -1 || address.indexOf("澳门") > -1 || address.indexOf("台湾") > -1) {
			if (address.indexOf("香港") > -1) {
				province = "香港";
				city = "特别行政区";
				if (addressFlag.indexOf(" ") > -1) {
					addressFlag = addressFlag.substring(addressFlag.indexOf(" ") + 1);
				}
				if (addressFlag.indexOf("区") > -1) {
					county = addressFlag.substring(0, addressFlag.indexOf("区")) + "区";
					addressFlag = addressFlag.substring(addressFlag.indexOf("区") + 1);
				}
			}
			if (address.indexOf("澳门") > -1) {
				province = "澳门";
				city = "特别行政区";
				if (addressFlag.indexOf(" ") > -1) {
					addressFlag = addressFlag.substring(addressFlag.indexOf(" ") + 1);
				} else {
					addressFlag = addressFlag.substring(addressFlag.indexOf("区") + 1);
				}
			}
			if (address.indexOf("台湾") > -1) {
				province = "台湾省";
				if (addressFlag.indexOf(" ") > -1) {
					addressFlag = addressFlag.substring(addressFlag.indexOf(" ") + 1);
				} else if (addressFlag.indexOf("省") > -1) {
					addressFlag = addressFlag.substring(addressFlag.indexOf("省") + 1);
				}
				if (addressFlag.indexOf("市") > -1) {
					city = addressFlag.substring(0, addressFlag.indexOf("市")) + "市";
					addressFlag = addressFlag.substring(addressFlag.indexOf("市") + 1);
				} else if (addressFlag.indexOf("县") > -1) {
					county = addressFlag.substring(0, addressFlag.indexOf("县")) + "县";
					addressFlag = addressFlag.substring(addressFlag.indexOf("县") + 1);
				}
			}
		} else {
			// 省名称
			int i = addressFlag.indexOf("省") > -1 ? 3 : 2;
			if (addressFlag.indexOf("黑龙江") > -1 || addressFlag.indexOf("内蒙古") > -1) {
				i += 1;
			}
			province = addressFlag.substring(0, i);
			if (province.indexOf("新疆") > -1) {
				province = "新疆维吾尔自治区";
			}
			if (province.indexOf("西藏") > -1) {
				province = "西藏自治区";
			}
			if (province.indexOf("宁夏") > -1) {
				province = "宁夏回族自治区";
			}
			if (province.indexOf("广西") > -1) {
				province = "广西壮族自治区";
			}
			if (province.indexOf("内蒙古") > -1) {
				province = "内蒙古自治区";
			}
			if (province.indexOf("自治区") > -1) {
				addressFlag = addressFlag.substring(addressFlag.indexOf("区") + 1);
			} else {
				addressFlag = addressFlag.substring(i);
			}
			// 市名称
			if (addressFlag.indexOf("市") > -1) {
				city = addressFlag.substring(0, addressFlag.indexOf("市")) + "市";
				addressFlag = addressFlag.substring(addressFlag.indexOf("市") + 1);
			} else if (addressFlag.indexOf("区划") > -1) {
				city = addressFlag.substring(0, addressFlag.indexOf("划")) + "划";
				addressFlag = addressFlag.substring(addressFlag.indexOf("划") + 1);
			} else if (addressFlag.indexOf("区") > -1) {
				city = addressFlag.substring(0, addressFlag.indexOf("区")) + "区";
				addressFlag = addressFlag.substring(addressFlag.indexOf("区") + 1);
			} else if (addressFlag.indexOf("州") > -1) {
				city = addressFlag.substring(0, addressFlag.indexOf("州")) + "州";
				addressFlag = addressFlag.substring(addressFlag.indexOf("州") + 1);
			} else if (addressFlag.indexOf("盟") > -1) {
				city = addressFlag.substring(0, addressFlag.indexOf("盟")) + "盟";
				addressFlag = addressFlag.substring(addressFlag.indexOf("盟") + 1);
			}
			// 区名称
			if (addressFlag.indexOf(" ") > -1) {
				addressFlag = addressFlag.substring(addressFlag.indexOf(" ") + 1);
			}
			if (addressFlag.indexOf("市") > -1) {
				county = addressFlag.substring(0, addressFlag.indexOf("市")) + "市";
				addressFlag = addressFlag.substring(addressFlag.indexOf("市") + 1);
			} else if (addressFlag.indexOf("区") > -1) {
				county = addressFlag.substring(0, addressFlag.indexOf("区")) + "区";
				addressFlag = addressFlag.substring(addressFlag.indexOf("区") + 1);
			} else if (addressFlag.indexOf("县") > -1) {
				county = addressFlag.substring(0, addressFlag.indexOf("县")) + "县";
				addressFlag = addressFlag.substring(addressFlag.indexOf("县") + 1);
			} else if (addressFlag.indexOf("镇") > -1) {
				county = addressFlag.substring(0, addressFlag.indexOf("镇")) + "镇";
				addressFlag = addressFlag.substring(addressFlag.indexOf("镇") + 1);
			}
		}
		// 获取街道名称
		street = StringUtils.isBlank(addressFlag) ? null : addressFlag;

		System.out.println(province + ", " + city + ", " + county + ", " + street);
	}


	public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
		String address = "广东省深圳市南山区中国储能大厦";
		splitPca(address);
	}

}
