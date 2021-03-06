package com.oligay.o2o.web.shopadmin;

import com.oligay.o2o.dto.ProductCategoryExecution;
import com.oligay.o2o.dto.Result;
import com.oligay.o2o.entity.ProductCategory;
import com.oligay.o2o.entity.Shop;
import com.oligay.o2o.enums.ProductCategoryStateEnum;
import com.oligay.o2o.exception.ProductCategoryOperationException;
import com.oligay.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/shopadmin")
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService productCategoryService;

	/**
	 * 
	 * 
	 * @Title: getProductCategoryByShopId
	 * 
	 * @Description: 根据ShopId获取productCategory
	 * 
	 * @param request
	 * 
	 * @return: Result<List<ProductCategory>>
	 */
	@RequestMapping(value = "/getproductcategorybyshopId", method = RequestMethod.GET)
	@ResponseBody
	public Result<List<ProductCategory>> getProductCategoryByShopId(HttpServletRequest request) {
		List<ProductCategory> productCategoryList ;
		ProductCategoryStateEnum ps;
		// 在进入到
		// shop管理页面（即调用getShopManageInfo方法时）,如果shopId合法，便将该shop信息放在了session中，key为currentShop
		// 这里我们不依赖前端的传入，因为不安全。 我们在后端通过session来做
		Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");

		if (currentShop != null && currentShop.getShopId() != null) {
			try {
				productCategoryList = productCategoryService.queryProductCategoryList(currentShop.getShopId());
				return new Result<List<ProductCategory>>(true, productCategoryList);
			} catch (Exception e) {
				e.printStackTrace();
				ps = ProductCategoryStateEnum.INNER_ERROR;
				return new Result<List<ProductCategory>>(false, ps.getState(), ps.getStateInfo());
			}
		} else {
			ps = ProductCategoryStateEnum.NULL_SHOP;
			return new Result<List<ProductCategory>>(false, ps.getState(), ps.getStateInfo());
		}
	}

	/**
	 * 
	 * 
	 * @Title: addProductCategory
	 * 
	 * @Description: 添加商铺目录 ，使用@RequestBody接收前端传递过来的productCategoryList
	 * 
	 * @param productCategoryList
	 * @param request
	 * 
	 * @return: Map<String,Object>
	 */
	@RequestMapping(value = "/addproductcategory", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addProductCategory(@RequestBody List<ProductCategory> productCategoryList, HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (productCategoryList != null && productCategoryList.size() > 0) {
			// 从session中获取shop的信息
			Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
			if (currentShop != null && currentShop.getShopId() != null) {
				// 为ProductCategory设置shopId
				for (ProductCategory productCategory : productCategoryList) {
					productCategory.setShopId(currentShop.getShopId());
				}
				try {
					// 批量插入
					ProductCategoryExecution pce = productCategoryService.addProductCategory(productCategoryList);
					if (pce.getState() == ProductCategoryStateEnum.SUCCESS.getState()) {
						modelMap.put("success", true);
						// 同时也将新增成功的数量返回给前台
						modelMap.put("effectNum", pce.getCount());
					} else {
						modelMap.put("success", false);
						modelMap.put("errMsg", pce.getStateInfo());
					}
				} catch (ProductCategoryOperationException e) {
					e.printStackTrace();
					modelMap.put("success", false);
					modelMap.put("errMsg", e.getMessage());
					return modelMap;
				}
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", ProductCategoryStateEnum.NULL_SHOP.getStateInfo());
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "至少输入一个店铺目录信息");
		}
		return modelMap;
	}

	/**
	 * 
	 * 
	 * @Title: remooveProductCategory
	 * 
	 * @Description: 删除商品目录
	 * 
	 * @param productCategoryId
	 * @param request
	 * 
	 * @return: Map<String,Object>
	 */
	@RequestMapping(value = "/removeproductcategory", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> remooveProductCategory(Long productCategoryId, HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (productCategoryId != null && productCategoryId > 0) {
			// 从session中获取shop的信息
			Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
			if (currentShop != null && currentShop.getShopId() != null) {
				try {
					// 删除
					Long shopId = currentShop.getShopId();
					ProductCategoryExecution pce = productCategoryService.deleteProductCategory(productCategoryId, shopId);
					if (pce.getState() == ProductCategoryStateEnum.SUCCESS.getState()) {
						modelMap.put("success", true);
					} else {
						modelMap.put("success", false);
						modelMap.put("errMsg", pce.getStateInfo());
					}
				} catch (ProductCategoryOperationException e) {
					e.printStackTrace();
					modelMap.put("success", false);
					modelMap.put("errMsg", e.getMessage());
					return modelMap;
				}
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", ProductCategoryStateEnum.NULL_SHOP.getStateInfo());
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请选择商品类别");
		}
		return modelMap;
	}

}
