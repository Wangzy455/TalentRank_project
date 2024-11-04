package vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户中心返回数据
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCenterVO {
    private Long id;
    private String username;
    private String name;
    private String webImg;
    private String introduce;
}
