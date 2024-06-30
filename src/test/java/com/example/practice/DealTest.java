package com.example.practice;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ArrayUtil;

public class DealTest {
    // 调度任务执行器所在服务
    public static void main6(String[] args) {
        String startCell = "A18";
        String[] equalStrArr = new String[]{
        };
        String[] likeStrArr = new String[]{"hcbm-contract."
                ,"hcbm-fulfill."
                ,"hcbm-system."
                ,"oc-base."
                ,"oc-es."
                ,"oc-office."
                ,"hzero-workflow."
                ,"hzero-esign."
                ,"hcbm-mdata."
                ,"hzero-platform."
                ,"oc-fulfill."
                ,"oc-mobile-center."
                ,"hzero-orchestration."
                ,"oc-wm."
                ,"oc-schedule."
                ,"hzero-interface."
                ,"hzero-platform."
                ,"hzero-iam."
                ,"of-base."
                ,"oc-platform-all."
                ,"oc-legal."
                ,"hzero-admin."};
        ListUtil.toList();
        StringBuilder result = new StringBuilder();
        result.append("=OR(1=2");
        for(String str :likeStrArr){
            if(str.contains("\\_")){
                str = str.replace("\\_","_");
            }
            result.append(",LEFT(");
            result.append(startCell);
            result.append(",");
            result.append(str.length());
            result.append(")=\"");
            result.append(str);
            result.append("\"");
        }
        for(String str :equalStrArr){
            if(str.contains("\\_")){
                str = str.replace("\\_","_");
            }
            result.append(",");
            result.append(startCell);
            result.append("=\"");
            result.append(str);
            result.append("\"");
        }
        result.append(")");
        System.out.println(result);
    }
    // 导入模板编码处理
    public static void main5(String[] args) {
        String startCell = "A27";
        String[] equalStrArr = new String[]{
        };
        String[] likeStrArr = new String[]{"CMDT."
                ,"CCRT."
                ,"CCFF."
                ,"CSYS."
                ,"SIGN."
                ,"BASE."
                ,"OCES."
                ,"CUX."
                ,"HPFM."
                ,"HWKF."
                ,"HOCF."
                ,"HIAM."
                ,"OSTP."
                ,"CIMP."
                ,"CPFM."
                ,"HPFM."
                ,"HMSG."};
        ListUtil.toList();
        StringBuilder result = new StringBuilder();
        result.append("=OR(1=2");
        for(String str :likeStrArr){
            if(str.contains("\\_")){
                str = str.replace("\\_","_");
            }
            result.append(",LEFT(");
            result.append(startCell);
            result.append(",");
            result.append(str.length());
            result.append(")=\"");
            result.append(str);
            result.append("\"");
        }
        for(String str :equalStrArr){
            if(str.contains("\\_")){
                str = str.replace("\\_","_");
            }
            result.append(",");
            result.append(startCell);
            result.append("=\"");
            result.append(str);
            result.append("\"");
        }
        result.append(")");
        System.out.println(result);
    }
    // 消息发送配置编码处理
    public static void main4(String[] args) {
        String startCell = "A16";
        String[] equalStrArr = new String[]{"HWKF_EMAIL_APPROVE"
        };
        String[] likeStrArr = new String[]{"OCES.",
                "HCBM.",
                "HCBM_",
                "HESG.",
                "BASE.",
                "CUX.",
                "OFFICE.",
                "FARA.",
                "HWFP.",
                "CYSY.",
                "OSTP.",
                "HWKF.",
                "HOTH.",
                "HIAM.",
                "HWKFT.",
                "HIPS.",
                "OFBASE.",
                "OCWM.",
                "ODS."};
        ListUtil.toList();
        StringBuilder result = new StringBuilder();
        result.append("=OR(1=2");
        for(String str :likeStrArr){
            if(str.contains("\\_")){
                str = str.replace("\\_","_");
            }
            result.append(",LEFT(");
            result.append(startCell);
            result.append(",");
            result.append(str.length());
            result.append(")=\"");
            result.append(str);
            result.append("\"");
        }
        for(String str :equalStrArr){
            if(str.contains("\\_")){
                str = str.replace("\\_","_");
            }
            result.append(",");
            result.append(startCell);
            result.append("=\"");
            result.append(str);
            result.append("\"");
        }
        result.append(")");
        System.out.println(result);
    }
    // 消息模板编码处理
    public static void main(String[] args) {
        String startCell = "A43";
        String[] equalStrArr = new String[]{"CHANGE_APPROVE_WARNING"
                ,"ES.BALANCE_WARNING"
                ,"NLP.BALANCE_WARNING"
                ,"QX.BALANCE_WARNING"
                ,"TEMPLATE_APPROVE_WARNING"
                ,"HWKF_EMAIL_APPROVE"
                ,"FILE_FREQUENT_DOWNLOAD"
                ,"CLIENT_ABNORMAL_IP"
                ,"USER_NUMBER_ALARM"
                ,"SUBSCRIPTION_EXPIRE_ALARM"
                ,"SUBSCRIPTION_LACK_ALARM"
        };
        String[] likeStrArr = new String[]{"CONTRACT_"
                ,"OCES."
                ,"HCBM."
                ,"HESG."
                ,"BASE."
                ,"CUX."
                ,"OFFICE."
                ,"FARA."
                ,"HWFP."
                ,"CYSY."
                ,"OSTP."
                ,"HWKF."
                ,"HOTH."
                ,"HIAM."
                ,"HWKFT."
                ,"HIPS."
                ,"OFBASE."
                ,"OCWM."
                ,"ODS."};
        ListUtil.toList();
        StringBuilder result = new StringBuilder();
        result.append("=OR(1=2");
        for(String str :likeStrArr){
            if(str.contains("\\_")){
                str = str.replace("\\_","_");
            }
            result.append(",LEFT(");
            result.append(startCell);
            result.append(",");
            result.append(str.length());
            result.append(")=\"");
            result.append(str);
            result.append("\"");
        }
        for(String str :equalStrArr){
            if(str.contains("\\_")){
                str = str.replace("\\_","_");
            }
            result.append(",");
            result.append(startCell);
            result.append("=\"");
            result.append(str);
            result.append("\"");
        }
        result.append(")");
        System.out.println(result);
    }    // 值集编码处理

    // 值集编码处理
    public static void main2(String[] args) {
        String startCell = "A44";
        String[] equalStrArr = new String[]{"LOV_VALUE_LANG_TYPE"
                ,"LOV_VIEW_LANG_TYPE"
                ,"IMPORT_TEMP_LANG_TYPE"
                ,"DASHBOARD_CARD_LANG_TYPE"
                ,"MENU_LANG_TYPE"
                ,"LOV_PROFILE_ROLE"
                ,"LOV_POSITION"
                ,"LOV_USER"
                ,"PROMISE.PAYMENT_LIST"
        };
        String[] likeStrArr = new String[]{"CCRT."
                ,"CSGN."
                ,"HCBM."
                ,"HCBM_"
                ,"HCHG."
                ,"SYSTEM."
                ,"BASE."
                ,"CCFF."
                ,"CMDT."
                ,"CMDT\\_"
                ,"CSYS."
                ,"DEMO."
                ,"OC_BASE."
                ,"OCBASE."
                ,"OC."
                ,"OCES"
                ,"OCBASE_"
                ,"HCBM_SYSTEM."
                ,"HPFM."
                ,"CHPF."
                ,"HOCF."
                ,"OFFICE."
                ,"HITF."
                ,"HWKF."
                ,"OSTP."
                ,"CUX."
                ,"APP."
                ,"HOCF"
                ,"CCFF_"
                ,"OC_ES."
                ,"HOCF_"
                ,"HIPS."
                ,"CPTL."
                ,"OCWM."
                ,"HIAM."
                ,"HMSG."
                ,"HORC."
                ,"OCLG."
                ,"OFBASE."
                ,"MOBILE"
                ,"HMDE"
                ,"CHPF"
                ,"CCRT_"
                ,"CUX"
                ,"ODS."
                ,"HFLE."
        };
        ListUtil.toList();
        StringBuilder result = new StringBuilder();
        result.append("=OR(1=2");
        for(String str :likeStrArr){
            if(str.contains("\\_")){
                str = str.replace("\\_","_");
            }
            result.append(",LEFT(");
            result.append(startCell);
            result.append(",");
            result.append(str.length());
            result.append(")=\"");
            result.append(str);
            result.append("\"");
        }
        for(String str :equalStrArr){
            if(str.contains("\\_")){
                str = str.replace("\\_","_");
            }
            result.append(",");
            result.append(startCell);
            result.append("=\"");
            result.append(str);
            result.append("\"");
        }
        result.append(")");
        System.out.println(result);
    }
    // 菜单编码处理
    public static void main1(String[] args) {
        String[] strArr = new String[]{"hcbm"
                ,"hcbm.site"
                ,"hcbm.borrow"
                ,"hcbm.change"
                ,"hcbm.contract"
                ,"hcbm.dashboard"
                ,"hcbm.end"
                ,"hcbm.execute"
                ,"hcbm.initialization-management"
                ,"hcbm.one.contract"
                ,"hcbm.sign"
                ,"hcbm.synergy-management"
                ,"hcbm.text-management"
                ,"hcbm.wk"
                ,"hzero.wp.setup.approval-manage"
                ,"hcbm.new-change"
                ,"hzero.new-change-second"
                ,"hcbm.new-contract"
                ,"hcbm.new-contract-second"
                ,"hcbm.purchasing-management"
                ,"hcbm.resource-manager"
                ,"hzero.contract.report.approval"
                ,"hzero.lowcode.data-model"
                ,"hcbm.mdata"
                ,"hcbm.system"
                ,"hcbm.template"
                ,"hcbm.fulfill"
                ,"hcbm.report-management"
                ,"hzero.clause"
                ,"hcbm.legal-fulfill"
                ,"hcbm.perform"
                ,"hcbm.fulfill-pos"
                ,"hcbm.po-fulfill"
                ,"hcbm.so-fulfill"
                ,"hzero.structured"
                ,"hzero.wp"
                ,"hzero.personality"
                ,"hzero.invoice"
                ,"hcbm.master-data"
                ,"hips.app.org"
                ,"hzero.organization"
                ,"hzero.user-config"
                ,"hcbm.wk.task"
                ,"hips.system"
                ,"hips.tripartite.platform.docking"
                ,"hcbm.questions"
                ,"hzero.sys"
                ,"hzero.mdm"
                ,"hcbm.new-party"
                ,"hzero.file"
                ,"hzero.file-aggregate"
                ,"hzero.file.water-mark-config"
                ,"hzero.site.sys"
                ,"hzero.site.sys.config"
                ,"hzero.site.sys.config.site.data-mapping"
                ,"hzero.site.sys.tenant"
                ,"hzero.site.sys.tenant.tenantscenarioconfiguration"
                ,"hzero.site.sys.tenant.tenantlnitialization"
                ,"hzero.site.sys.contract-change-type-config"
                ,"hzero.site.sys.contract-archiving-content"
                ,"hzero.hwkf"
                ,"hcbm.report-manage"
                ,"hcbm.archive"
                ,"hcbm.sub.audit"
                ,"hcbm.semantics"
                ,"hzero.site.hmnt"
                ,"hzero.hzero.initialization-management"
                ,"hzero.hzero.transaction.flow"
                ,"hzero.dev.setup_lovconfig_view"
                ,"hzero.msg"
                ,"hzero.msg.user-message"
                ,"hzero.hwkf.process_oc"
                ,"hzero.dev"
                ,"hzero.site.dev"
                ,"hzero.site.hwkf"
                ,"hcbm.wk.task"
                ,"hcbm.mobile"
                ,"hzero.horc"
                ,"hzero.himp"
                ,"HWKF.CARD.FORM"
                ,"hcbm.cooperate-management"
                ,"hcbm.royalty-rent-management"
                ,"hzero.transaction.flow.system_scriptevent"
                ,"hzero.transaction.flow"
                ,"hzero.hwkf.personal-process.process.promotion_approval"
                ,"hzero.hwkf.setup.process-definition"
                ,"hcbm.cross-group-contract.create"
                ,"od.docusign"
                ,"hzero.site.business-object"
                ,"hzero.site.lowcode"
                ,"hzero.site.modeler"
                ,"hzero.modeler"
                ,"hzero.business-object"
                ,"hzero.application"
                ,"hzero.hlcd"
                ,"hzero.sre"};
        ListUtil.toList();
        StringBuilder result = new StringBuilder();
        result.append("=OR(ISNUMBER(SEARCH(\"v2\",A10))");
        for(String str :strArr){
            if(str.contains("\\_")){
                str.replace("\\_","_");
            }
            result.append(",LEFT(A10,");
            result.append(str.length());
            result.append(")=\"");
            result.append(str);
            result.append("\"");
        }
        result.append(")");
        System.out.println(result);
    }
}
